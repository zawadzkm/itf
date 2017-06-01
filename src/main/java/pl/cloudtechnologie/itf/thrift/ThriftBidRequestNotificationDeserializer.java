package pl.cloudtechnologie.itf.thrift;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

public class ThriftBidRequestNotificationDeserializer {
    private TDeserializer deserializer;

    public ThriftBidRequestNotificationDeserializer() {
        deserializer = new TDeserializer(new TBinaryProtocol.Factory());
    }
    public ThriftBidRequestNotification deserialize(byte[] data) throws TException {
        ThriftBidRequestNotification msg = new ThriftBidRequestNotification();
        deserializer.deserialize(msg, data);
        return msg;
    }

}
