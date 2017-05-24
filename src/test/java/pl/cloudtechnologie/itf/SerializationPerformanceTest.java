package pl.cloudtechnologie.itf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.thrift.TException;
import pl.cloudtechnologie.itf.avro.AvroBidRequestNotification;
import pl.cloudtechnologie.itf.avro.AvroBidRequestNotificationDeserializer;
import pl.cloudtechnologie.itf.avro.AvroBidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.avro.AvroBidRequestNotificationSerializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationDeserializer;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.proto.BidRequestNotificationSerializer;
import pl.cloudtechnologie.itf.proto.CtProtos;
import pl.cloudtechnologie.itf.thrift.ThriftBidRequestNotification;
import pl.cloudtechnologie.itf.thrift.ThriftBidRequestNotificationDeserializer;
import pl.cloudtechnologie.itf.thrift.ThriftBidRequestNotificationGenerator;
import pl.cloudtechnologie.itf.thrift.ThriftBidRequestNotificationSerializer;

import java.io.IOException;

public class SerializationPerformanceTest {
    private static long MSG_COUNT = 10000000;


    public static void main(String[] args) {
        SerializationPerformanceTest test = new SerializationPerformanceTest();
        try {
            test.run();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException, TException {
        runProto();
        runAvro();
        runThrift();
    }

    public void runProto() throws InvalidProtocolBufferException {
        BidRequestNotificationGenerator gen = new BidRequestNotificationGenerator();
        BidRequestNotificationSerializer serializer = new BidRequestNotificationSerializer();
        BidRequestNotificationDeserializer deserializer = new BidRequestNotificationDeserializer();
        CtProtos.BidRequestNotification msg1, msg2;
        byte[] bytes;

        long start = System.currentTimeMillis();
        for (int i = 0; i < MSG_COUNT; i++) {
            msg1 = gen.nextMsg();
            bytes = serializer.serialize(null, msg1);
            msg2 = deserializer.deserialize(null, bytes);
        }
        long end = System.currentTimeMillis();
        float speed = MSG_COUNT/(float)(end-start)*1000;

        System.out.println(String.format("%d messages processed in %d miliseconds", MSG_COUNT, end-start));
        System.out.println(String.format("%,.1f msg/s", speed));
    }

    public void runAvro() throws IOException {
        AvroBidRequestNotificationGenerator gen = new AvroBidRequestNotificationGenerator();
        AvroBidRequestNotification msg1, msg2;
        AvroBidRequestNotificationSerializer serializer = new AvroBidRequestNotificationSerializer();
        AvroBidRequestNotificationDeserializer deserializer = new AvroBidRequestNotificationDeserializer();

        byte[] bytes;

        long start = System.currentTimeMillis();
        for (int i = 0; i < MSG_COUNT; i++) {
            msg1 = gen.nextMsg();
            bytes = serializer.serialize(null, msg1);
            msg2 = deserializer.deserialize(null, bytes);
        }
        long end = System.currentTimeMillis();
        float speed = MSG_COUNT/(float)(end-start)*1000;

        System.out.println(String.format("%d messages processed in %d miliseconds", MSG_COUNT, end-start));
        System.out.println(String.format("%,.1f msg/s", speed));

    }

    public void runThrift() throws IOException, TException {
        ThriftBidRequestNotificationGenerator gen = new ThriftBidRequestNotificationGenerator();
        ThriftBidRequestNotification msg1, msg2;
        ThriftBidRequestNotificationSerializer serializer = new ThriftBidRequestNotificationSerializer();
        ThriftBidRequestNotificationDeserializer deserializer = new ThriftBidRequestNotificationDeserializer();

        byte[] bytes;

        long start = System.currentTimeMillis();
        for (int i = 0; i < MSG_COUNT; i++) {
            msg1 = gen.nextMsg();
            bytes = serializer.serialize(null, msg1);
            msg2 = deserializer.deserialize(null, bytes);
        }
        long end = System.currentTimeMillis();
        float speed = MSG_COUNT/(float)(end-start)*1000;

        System.out.println(String.format("%d messages processed in %d miliseconds", MSG_COUNT, end-start));
        System.out.println(String.format("%,.1f msg/s", speed));

    }
}

