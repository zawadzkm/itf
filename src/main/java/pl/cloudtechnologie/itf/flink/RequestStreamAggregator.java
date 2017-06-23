package pl.cloudtechnologie.itf.flink;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;
import pl.cloudtechnologie.itf.proto.CtProtos.CalculateSegments;
import pl.cloudtechnologie.itf.proto.CtProtos.BidRequestNotification;

import java.io.IOException;
import java.util.Properties;

public class RequestStreamAggregator {

    public static String PROPERTIES_PATH = "itf.properties";
    private ParameterTool parameter;

    public void getProperties() throws IOException {
        parameter = ParameterTool.fromPropertiesFile(PROPERTIES_PATH);
        System.out.println(parameter.toMap().toString());
    }

    public void run() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        Properties props = new Properties();
        props.setProperty("zookeeper.connect", parameter.get("itf.zookeepers"));
        props.setProperty("bootstrap.servers", parameter.get("itf.brokers"));
        props.setProperty("group.id", parameter.get("itf.aggregator.group_id"));
        props.setProperty("auto.offset.reset", "earliest");

        FlinkKafkaConsumer010<BidRequestNotification> consumer =
                new FlinkKafkaConsumer010(parameter.get("itf.topTopic"), new BidRequestNotificationSchema(), props);

        DataStream<BidRequestNotification> requests = env.addSource(consumer);

        DataStream<CalculateSegments> userIdCounts = requests
                .map(new RequestStreamTransformer())
                .keyBy(new RequestStreamTransformer())
                .window(TumblingProcessingTimeWindows.of(Time.seconds(parameter.getInt("itf.aggregator.window"))))
                .reduce(new RequestStreamTransformer());

        userIdCounts.addSink(new FlinkKafkaProducer010<CalculateSegments>(
                        parameter.get("itf.brokers"),
                        parameter.get("itf.calculateSegmentsTopic"),
                        new CalculateSegmentsSchema())
        );

        env.execute();
    }

    public static void main(String[] args) throws Exception {
        RequestStreamAggregator aggregator = new RequestStreamAggregator();
        aggregator.getProperties();
        aggregator.run();
    }
}
