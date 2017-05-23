package pl.cloudtechnologie.itf.proto;

import pl.cloudtechnologie.itf.proto.CtProtos.BidRequestNotification;
import java.util.Random;

public class BidRequestNotificationGenerator {
    static int USER_ID_MIN = 10000000;
    static int USER_ID_MAX = 10999999;
    static int HOST_HASH_MIN = 10000000;
    static int HOST_HASH_MAX = 999999909;
    static int USER_AGENT_MIN = 1000;
    static int USER_AGENT_MAX = 9999;
    static int IP_ADDRESS_MIN = 1000;
    static int IP_ADDRESS_MAX = 9999;

    private Random random;

    public BidRequestNotificationGenerator() {
        random = new Random(System.currentTimeMillis());
    }

    public BidRequestNotification nextMsg() {

        return BidRequestNotification.newBuilder()
                .setUserId(random.nextInt(USER_ID_MAX - USER_ID_MIN) + USER_ID_MIN)
                .setHostHash(random.nextInt(HOST_HASH_MAX - HOST_HASH_MIN) + HOST_HASH_MIN)
                .setUserAgent(random.nextInt(USER_AGENT_MAX - USER_AGENT_MIN) + USER_AGENT_MIN)
                .setIpAddress(random.nextInt(IP_ADDRESS_MAX - IP_ADDRESS_MIN) + IP_ADDRESS_MIN)
                .setTimestamp(System.currentTimeMillis())
                .build();
    }
}
