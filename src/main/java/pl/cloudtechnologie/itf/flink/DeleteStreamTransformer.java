package pl.cloudtechnologie.itf.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import pl.cloudtechnologie.itf.proto.CtProtos.UpdateSegments;

public class DeleteStreamTransformer implements MapFunction<UpdateSegments, Tuple1<Long>> {

    public Tuple1<Long> map(UpdateSegments request) throws Exception {
        return new Tuple1<Long>(request.getUserId());
    }
}