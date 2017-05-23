package pl.cloudtechnologie.itf.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import pl.cloudtechnologie.itf.proto.CtProtos.BidRequestNotification;
import pl.cloudtechnologie.itf.proto.CtProtos.CalculateSegments;

public class RequestStreamTransformer implements MapFunction<BidRequestNotification, CalculateSegments>,
        KeySelector<CalculateSegments, Long>,
        ReduceFunction<CalculateSegments> {

    public Long getKey(CalculateSegments uic) {
        return uic.getUserId();
    }

    public CalculateSegments reduce(CalculateSegments a, CalculateSegments b) {
        return CalculateSegments.newBuilder()
                .setUserId(a.getUserId())
                .setMsgCount(a.getMsgCount()+b.getMsgCount())
                .build();
    }

    public CalculateSegments map(BidRequestNotification request) throws Exception {
        return CalculateSegments.newBuilder()
                .setUserId(request.getUserId())
                .setMsgCount(1L)
                .build();
    }
}
