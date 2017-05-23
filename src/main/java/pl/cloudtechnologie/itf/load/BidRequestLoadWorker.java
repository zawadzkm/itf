package pl.cloudtechnologie.itf.load;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationSerializer;

import java.util.Properties;

public class BidRequestLoadWorker extends Thread {

    private int msg_count;
    private BidRequestNotificationGenerator bidRequestNotificationGenerator;
    private static String topic = "itf.fromTop";
    private KafkaProducer<Integer, CtProtos.BidRequestNotification> producer;

    public BidRequestLoadWorker(int iter) {
        msg_count = iter;
        bidRequestNotificationGenerator = new BidRequestNotificationGenerator();

        Properties props = new Properties();
        props.put("acks", "0");
        props.put("batch.size", 131072);
        props.put("linger.ms", 5);
//        props.put("bootstrap.servers", "localhost:9092");
        props.put("bootstrap.servers", "server1:9092,server2:9092");
        props.put("client.id", "BidRequestNotificationProducer");
        producer = new KafkaProducer(props, new IntegerSerializer(), new BidRequestNotificationSerializer());
    }

    public void run() {
        CtProtos.BidRequestNotification msg;

        for (int i=0; i<msg_count; i++){
                producer.send(new ProducerRecord(topic, bidRequestNotificationGenerator.nextMsg()));
        }
        producer.close();
    }
}
