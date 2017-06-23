package pl.cloudtechnologie.itf.flink;

import org.apache.flink.api.common.functions.MapFunction;
import pl.cloudtechnologie.itf.proto.CtProtos.UpdateSegments;

public class UpdateStreamTransformer implements MapFunction<UpdateSegments, UpdateSegmentsObject> {

    public UpdateSegmentsObject map(UpdateSegments request) throws Exception {
        return new UpdateSegmentsObject(request.getUserId(), request.getSegmentsList(), request.getPartnerUserIdsList());
    }
}
