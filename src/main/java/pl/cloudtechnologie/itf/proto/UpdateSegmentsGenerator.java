package pl.cloudtechnologie.itf.proto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UpdateSegmentsGenerator {
    static int USER_ID_MIN = 10000000;
    static int USER_ID_MAX = 10999999;
    static int PARTNER_ID_MIN = 10000;
    static int PARTNER_ID_MAX = 99999;
    static int SEGMENT_ID_MIN = 10000;
    static int SEGMENT_ID_MAX = 99999;
    static int PARTNERS_MIN = 5;
    static int PARTNERS_MAX = 50;
    static int SEGMENTS_MIN = 5;
    static int SEGMENTS_MAX = 20;

    private Random random;

    public UpdateSegmentsGenerator() {
        random = new Random(System.currentTimeMillis());
    }

    public CtProtos.UpdateSegments nextMsg() {
        List<CtProtos.PartnerUserId> partners = new LinkedList<CtProtos.PartnerUserId>();
        List<Integer> segments = new LinkedList<Integer>();

        if (Math.random()>0.05) {
            for (int i = 0; i < random.nextInt(SEGMENTS_MAX - SEGMENTS_MIN) + SEGMENTS_MIN; i++) {
                segments.add(random.nextInt(SEGMENT_ID_MAX - SEGMENT_ID_MIN) + SEGMENT_ID_MIN);
            };
        }

        for (int i = 0; i < random.nextInt(PARTNERS_MAX - PARTNERS_MIN) + PARTNERS_MIN; i++) {
            partners.add(CtProtos.PartnerUserId.newBuilder()
                    .setPartnerId(random.nextInt(PARTNER_ID_MAX - PARTNER_ID_MIN) + PARTNER_ID_MIN)
                    .setUsrId(random.nextInt(USER_ID_MAX - USER_ID_MIN) + USER_ID_MIN)
                    .build()
            );
        }

        return CtProtos.UpdateSegments.newBuilder()
                .setUserId(random.nextInt(USER_ID_MAX - USER_ID_MIN) + USER_ID_MIN)
                .addAllPartnerUserIds(partners)
                .addAllSegments(segments)
                .build();
    }

}
