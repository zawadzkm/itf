package pl.cloudtechnologie.itf.thrift;

import java.util.Random;

public class ThriftBidRequestNotificationGenerator {
    static int USER_ID_MIN = 10000000;
    static int USER_ID_MAX = 10999999;
    static int HOST_HASH_MIN = 10000000;
    static int HOST_HASH_MAX = 999999909;
    static int USER_AGENT_MIN = 1000;
    static int USER_AGENT_MAX = 9999;
    static int IP_ADDRESS_MIN = 1000;
    static int IP_ADDRESS_MAX = 9999;

    private Random random;

    public ThriftBidRequestNotificationGenerator() {
        random = new Random(System.currentTimeMillis());
    }

    public ThriftBidRequestNotification nextMsg() {
        return new ThriftBidRequestNotification(
                (long)(random.nextInt(USER_ID_MAX - USER_ID_MIN) + USER_ID_MIN),
                (long)(random.nextInt(HOST_HASH_MAX - HOST_HASH_MIN) + HOST_HASH_MIN),
                random.nextInt(USER_AGENT_MAX - USER_AGENT_MIN) + USER_AGENT_MIN,
                random.nextInt(IP_ADDRESS_MAX - IP_ADDRESS_MIN) + IP_ADDRESS_MIN,
                System.currentTimeMillis()
        );
    }
}

