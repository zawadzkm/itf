package pl.cloudtechnologie.itf.flink;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;
import pl.cloudtechnologie.itf.proto.CtProtos.CalculateSegments;

public class CalculateSegmentsSchema implements DeserializationSchema<CalculateSegments>, SerializationSchema<CalculateSegments> {

        public byte[] serialize(CalculateSegments element) {
            return element.toByteArray();
        }

        public CalculateSegments deserialize(byte[] message) {
            try {
                return CalculateSegments.parseFrom(message);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            return null;
        }

        public boolean isEndOfStream(CalculateSegments nextElement) {
            return false;
        }

        public TypeInformation<CalculateSegments> getProducedType() {
            return TypeExtractor.getForClass(CalculateSegments.class);
        }
    }
