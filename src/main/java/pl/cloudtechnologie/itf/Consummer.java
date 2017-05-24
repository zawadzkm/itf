package pl.cloudtechnologie.itf;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationDeserializer;
import pl.cloudtechnologie.itf.proto.CtProtos;

import java.util.Collections;
import java.util.Properties;

public class Consummer extends ShutdownableThread {
    private final KafkaConsumer<Integer, CtProtos.BidRequestNotification> consumer;
    private final String topic;

    public Consummer() {
        super("KafkaConsumer", false);

        Properties props = new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "server1:9092,server2:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "BidConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");

        consumer = new KafkaConsumer(props, new IntegerDeserializer(), new BidRequestNotificationDeserializer());
        this.topic = "itf.fromTop";
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer, CtProtos.BidRequestNotification> records = consumer.poll(3000);
        System.out.println(records.count());
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }
}
