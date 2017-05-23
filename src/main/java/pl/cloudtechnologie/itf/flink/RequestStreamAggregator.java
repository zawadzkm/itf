package pl.cloudtechnologie.itf.flink;

import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;
import pl.cloudtechnologie.itf.proto.CtProtos.CalculateSegments;
import pl.cloudtechnologie.itf.proto.CtProtos.BidRequestNotification;

import java.util.Properties;

public class RequestStreamAggregator {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        Properties props = new Properties();
//        props.setProperty("zookeeper.connect", "localhost:2181");
//        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("zookeeper.connect", "server1:2181,server2:2181");
        props.setProperty("bootstrap.servers", "server1:9092,server2:9092");
        props.setProperty("group.id", "itf.topAggregator");
        props.setProperty("auto.offset.reset", "earliest");

        FlinkKafkaConsumer010<BidRequestNotification> consumer =
                new FlinkKafkaConsumer010("itf.fromTop", new BidRequestNotificationSchema(), props);

        DataStream<BidRequestNotification> requests = env.addSource(consumer);

        DataStream<CalculateSegments> userIdCounts = requests
                .map(new RequestStreamTransformer())
                .keyBy(new RequestStreamTransformer())
                .window(TumblingProcessingTimeWindows.of(Time.seconds(30)))
                .reduce(new RequestStreamTransformer());

//        userIdCounts.print();
            userIdCounts.addSink(new FlinkKafkaProducer010<CalculateSegments>(
//                    "localhost:9092",
                    "server1:9092,server2:9092",
                    "itf.calculateSegments",
                    new CalculateSegmentsSchema())
            );

        env.execute();

    }
}
