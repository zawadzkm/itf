package pl.cloudtechnologie.itf.proto;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class BidRequestNotificationDeserializer implements Deserializer<CtProtos.BidRequestNotification> {

    public void close() {}

    public void configure(Map<String,?> configs, boolean isKey) {}

    public CtProtos.BidRequestNotification deserialize(final String topic, byte[] data) {
        try {
            return CtProtos.BidRequestNotification.parseFrom(data);
        } catch (final InvalidProtocolBufferException e) {
            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
        }
    }
}
