package pl.cloudtechnologie.itf.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

public class ThriftBidRequestNotificationSerializer {
    private TSerializer serializer;

    public ThriftBidRequestNotificationSerializer() {
        serializer = new TSerializer(new TBinaryProtocol.Factory());
    }

    public byte[] serialize(final ThriftBidRequestNotification data) throws TException {
       return serializer.serialize(data);
    }
}
