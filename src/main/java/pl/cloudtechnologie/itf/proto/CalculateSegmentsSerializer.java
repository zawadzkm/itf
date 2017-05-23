package pl.cloudtechnologie.itf.proto;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CalculateSegmentsSerializer implements Serializer<CtProtos.CalculateSegments> {

    public void close() {}

    public void configure(Map<String,?> configs, boolean isKey) {}

    public byte[] serialize(final String topic, final CtProtos.CalculateSegments data) {

        return data.toByteArray();
    }
}