package pl.cloudtechnologie.itf.proto;

import org.apache.kafka.common.serialization.Serializer;
import java.util.Map;

public class UpdateSegmentsSerializer implements Serializer<CtProtos.UpdateSegments> {
    public void close() {}

    public void configure(Map<String,?> configs, boolean isKey) {}

    public byte[] serialize(final String topic, final CtProtos.UpdateSegments data) {

        return data.toByteArray();
    }
}
