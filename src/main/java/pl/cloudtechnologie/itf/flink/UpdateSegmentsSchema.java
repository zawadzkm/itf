package pl.cloudtechnologie.itf.flink;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;
import pl.cloudtechnologie.itf.proto.CtProtos.UpdateSegments;

public class UpdateSegmentsSchema implements DeserializationSchema<UpdateSegments>, SerializationSchema<UpdateSegments> {

    public byte[] serialize(UpdateSegments element) {
        return element.toByteArray();
    }

    public UpdateSegments deserialize(byte[] message) {
        try {
            return UpdateSegments.parseFrom(message);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isEndOfStream(UpdateSegments nextElement) {
        return false;
    }

    public TypeInformation<UpdateSegments> getProducedType() {
        return TypeExtractor.getForClass(UpdateSegments.class);
    }
}