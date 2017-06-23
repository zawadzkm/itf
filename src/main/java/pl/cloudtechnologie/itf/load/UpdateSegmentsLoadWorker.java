package pl.cloudtechnologie.itf.load;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import pl.cloudtechnologie.itf.proto.CtProtos.UpdateSegments;
import pl.cloudtechnologie.itf.proto.UpdateSegmentsGenerator;
import pl.cloudtechnologie.itf.proto.UpdateSegmentsSerializer;

import java.io.IOException;
import java.util.Properties;


public class UpdateSegmentsLoadWorker extends Thread {

    private ParameterTool parameter;

    private int duration;

    private volatile int messages = 0;

    private UpdateSegmentsGenerator generator;
    private KafkaProducer<Integer, UpdateSegments> producer;

    public UpdateSegmentsLoadWorker(int time) throws IOException {
        parameter = ParameterTool.fromPropertiesFile(UpdateSegmentsLoadGenerator.PROPERTIES_PATH);

        duration = time;
        generator = new UpdateSegmentsGenerator();

        Properties props = new Properties();
        props.put("acks", "0");
        props.put("batch.size", 131072);
        props.put("linger.ms", 5);
        props.put("bootstrap.servers", parameter.get("itf.brokers"));
        props.put("client.id", parameter.get("itf.test.updateload.client_id"));
        producer = new KafkaProducer(props, new IntegerSerializer(), new UpdateSegmentsSerializer());
    }

    public int getMessages() {
        return messages;
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < duration) {
            producer.send(new ProducerRecord(parameter.get("itf.updateSegmentsTopic"), generator.nextMsg()));
            messages = messages+1;
        }

        producer.flush();
        producer.close();

    }
}
