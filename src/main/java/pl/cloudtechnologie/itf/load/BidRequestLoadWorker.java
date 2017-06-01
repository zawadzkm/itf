package pl.cloudtechnologie.itf.load;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationSerializer;
import pl.cloudtechnologie.itf.proto.CtProtos;

import java.io.IOException;
import java.util.Properties;

public class BidRequestLoadWorker extends Thread {

    private ParameterTool parameter;

    private int duration;

    private volatile int messages = 0;

    private BidRequestNotificationGenerator generator;
    private KafkaProducer<Integer, CtProtos.BidRequestNotification> producer;

    public BidRequestLoadWorker(int time) throws IOException {
        parameter = ParameterTool.fromPropertiesFile(GenerateBidRequestLoad.PROPERTIES_PATH);

        duration = time;
        generator = new BidRequestNotificationGenerator();

        Properties props = new Properties();
        props.put("acks", "0");
        props.put("batch.size", 131072);
        props.put("linger.ms", 5);
        props.put("bootstrap.servers", parameter.get("itf.brokers"));
        props.put("client.id", parameter.get("itf.test.requestload.client_id"));
        producer = new KafkaProducer(props, new IntegerSerializer(), new BidRequestNotificationSerializer());
    }

    public int getMessages() {
        return messages;
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < duration) {
            messages = messages+1;
            producer.send(new ProducerRecord(parameter.get("itf.topTopic"), generator.nextMsg()));
        }

        producer.flush();
        producer.close();

    }
}
