package pl.cloudtechnologie.itf.flink;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Table;
import pl.cloudtechnologie.itf.proto.CtProtos.PartnerUserId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Table(keyspace= "itf", name = "segments")

public class UpdateSegmentsObject {

    @Column(name = "userid")
    private long userId;

    @Column(name = "segments")
    private List<Integer> segments;

    @Column(name = "partnersuserids")
    private Map<Integer, Integer> partnerUserIds;

    public UpdateSegmentsObject(long uid, List<Integer> segs, List<PartnerUserId> pars) {
        setUserId(uid);
        setSegments(segs);
        setPartnerUserIds(new HashMap<Integer, Integer>());
        for (PartnerUserId p : pars) {
            getPartnerUserIds().put(p.getPartnerId(), p.getUsrId());
        }
    }

    public int getSegmentsCount() {
        return getSegments().size();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Integer> getSegments() {
        return segments;
    }

    public void setSegments(List<Integer> segments) {
        this.segments = segments;
    }

    public Map<Integer, Integer> getPartnerUserIds() {
        return partnerUserIds;
    }

    public void setPartnerUserIds(Map<Integer, Integer> partnerUserIds) {
        this.partnerUserIds = partnerUserIds;
    }
}
