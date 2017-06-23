package pl.cloudtechnologie.itf.flink;

import com.twitter.chill.protobuf.ProtobufSerializer;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.collector.selector.OutputSelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.cassandra.CassandraSink;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import pl.cloudtechnologie.itf.proto.CtProtos.UpdateSegments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SegmentsStreamUpdater {
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
        props.setProperty("group.id", parameter.get("itf.updater.group_id"));
        props.setProperty("auto.offset.reset", "earliest");

        FlinkKafkaConsumer010<UpdateSegments> consumer =
                new FlinkKafkaConsumer010(parameter.get("itf.updateSegmentsTopic"), new UpdateSegmentsSchema(), props);

        DataStream<UpdateSegments> requests = env.addSource(consumer);

        SplitStream<UpdateSegments> split = requests.split(new OutputSelector<UpdateSegments>() {

            public Iterable<String> select(UpdateSegments request) {
                List<String> output = new ArrayList<String>();
                if (request.getSegmentsCount() == 0)
                    output.add("delete");
                else
                    output.add("update");
                return output;
            }
        });

        DataStream<UpdateSegmentsObject> update = split.select("update").map(new UpdateStreamTransformer());;
        DataStream<Tuple1<Long>> delete = split.select("delete").map(new DeleteStreamTransformer());;

        CassandraSink
                .addSink(update)
                .setHost(parameter.get("itf.cassandra.host"),  parameter.getInt("itf.cassandra.port"))
                .build();

        CassandraSink
                .addSink(delete)
                .setQuery("DELETE FROM itf.segments where userid = ?;")
                .setHost(parameter.get("itf.cassandra.host"),  parameter.getInt("itf.cassandra.port"))
                .build();

        env.getConfig().registerTypeWithKryoSerializer(UpdateSegments.class, ProtobufSerializer.class);
        env.execute();
    }

    public static void main(String[] args) throws Exception {
        SegmentsStreamUpdater updater = new SegmentsStreamUpdater();
        updater.getProperties();
        updater.run();
    }

}
