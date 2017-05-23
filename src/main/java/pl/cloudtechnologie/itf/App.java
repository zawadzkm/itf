package pl.cloudtechnologie.itf;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class App {


    public static void main( String[] args ) {

        String topic = "itf.fromTop";
        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
        props.put("bootstrap.servers", "77.79.227.33:9092");
        props.put("client.id", "BidRequestNotificationProducer");
        KafkaProducer<Integer, CtProtos.BidRequestNotification> producer = new KafkaProducer(props, new IntegerSerializer(), new BidRequestNotificationSerializer());

        BidRequestNotificationGenerator gen = new BidRequestNotificationGenerator();
System.out.println("111");
        try {
            for (int i = 0; i < 1; i++) {
                producer.send(new ProducerRecord(topic, gen.nextMsg())).get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println( "Victory!" );
    }
}
