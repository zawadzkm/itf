package pl.cloudtechnologie.itf.flink;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;
import pl.cloudtechnologie.itf.proto.CtProtos.BidRequestNotification;

public class BidRequestNotificationSchema implements DeserializationSchema<BidRequestNotification>, SerializationSchema<BidRequestNotification> {

    public byte[] serialize(BidRequestNotification element) {
        return element.toByteArray();
    }

    public BidRequestNotification deserialize(byte[] message) {
        try {
            return BidRequestNotification.parseFrom(message);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isEndOfStream(BidRequestNotification nextElement) {
        return false;
    }

    public TypeInformation<BidRequestNotification> getProducedType() {
        return TypeExtractor.getForClass(BidRequestNotification.class);
    }
}
