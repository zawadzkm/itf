package pl.cloudtechnologie.itf.proto;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

public class UpdateSegmentsDeserializer implements Deserializer<CtProtos.UpdateSegments> {

    public void close() {}

    public void configure(Map<String,?> configs, boolean isKey) {}

    public CtProtos.UpdateSegments deserialize(final String topic, byte[] data) {
        try {
            return CtProtos.UpdateSegments.parseFrom(data);
        } catch (final InvalidProtocolBufferException e) {
            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
        }
    }
}
