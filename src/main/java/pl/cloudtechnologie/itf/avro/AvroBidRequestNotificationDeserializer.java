package pl.cloudtechnologie.itf.avro;

import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.IOException;

public class AvroBidRequestNotificationDeserializer {

    public AvroBidRequestNotification deserialize(byte[] data) throws IOException {
        SpecificDatumReader<AvroBidRequestNotification> reader = new SpecificDatumReader<AvroBidRequestNotification>(AvroBidRequestNotification.getClassSchema());
        Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
        return reader.read(null, decoder);
    }

}
