package pl.cloudtechnologie.itf.avro;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroBidRequestNotificationSerializer {

    public byte[] serialize(final AvroBidRequestNotification data) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        DatumWriter<AvroBidRequestNotification> writer = new SpecificDatumWriter<AvroBidRequestNotification>(AvroBidRequestNotification.getClassSchema());

        writer.write(data, encoder);
        encoder.flush();
        out.close();
        return out.toByteArray();
    }

}
