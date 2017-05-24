package pl.cloudtechnologie.itf.load;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationSerializer;
import pl.cloudtechnologie.itf.proto.CtProtos;

import java.util.Properties;

public class BidRequestLoadWorker extends Thread {

    private int ms;
    private volatile int msgs = 0;

    private BidRequestNotificationGenerator generator;
    private static String topic = "itf.fromTop";
    private KafkaProducer<Integer, CtProtos.BidRequestNotification> producer;

    public BidRequestLoadWorker(int time) {
        ms = time;
        generator = new BidRequestNotificationGenerator();

        Properties props = new Properties();
        props.put("acks", "0");
        props.put("batch.size", 131072);
        props.put("linger.ms", 5);
        props.put("bootstrap.servers", "localhost:9092");
//        props.put("bootstrap.servers", "server1:9092,server2:9092");
        props.put("client.id", "BidRequestNotificationProducer");
        producer = new KafkaProducer(props, new IntegerSerializer(), new BidRequestNotificationSerializer());
    }

    public int getMsgs() {
        return msgs;
    }

    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < ms) {
            msgs = msgs+1;
            producer.send(new ProducerRecord(topic, generator.nextMsg()));
        }

        producer.flush();
        producer.close();

    }
}
