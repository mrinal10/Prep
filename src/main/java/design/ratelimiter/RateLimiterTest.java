package design.ratelimiter;

import java.util.concurrent.TimeUnit;
/**
 *
 * This is a simple test for a rate limiter.
 * We can build the RateLimitExecutor object and set the following
 * attributes:
 * a) instance_id — which acts as a key to uniquely identify the rate
 * limiting policy
 * b) threshold — the Transactions per second to be controlled
 * (throttle limit)
 * Based on this information, provision the rate limiter in a
 * container class — Rate Limit Manager
 * This class then pumps loads through iterations, and sleep time to
 * control traffic ingestion.
 */
public class RateLimiterTest implements RateLimitListener {
    private static long iterations = 1000;
    private static long threshold_to_be_enforced = 100;
    private static long sleepTime = 0;


    public static void main (String[] args) throws InterruptedException {
        String instance_id = "HTTP Interface";
        RateLimitExecutor rateLimiter = new RateLimitExecutor();
        rateLimiter.build(TimeUnit.SECONDS, threshold_to_be_enforced);
        rateLimiter.setInstance_id(instance_id);
        RateLimitManager._instance.provisionRateLimit(rateLimiter, instance_id, new RateLimitThrottleListener());

        for (int i=0; i<iterations; i++) {
            RateLimitManager._instance.pegTraffic(instance_id);
            Thread.sleep(sleepTime);
        }

        try {
            RateLimitManager._instance.getThreadPool().awaitTermination(2, TimeUnit.SECONDS);
            RateLimitManager._instance.deProvisionRateLimit(instance_id);
        } catch (InterruptedException e) {
            System.exit(0);
        }
        System.out.println("\n Test Ended \n");
        System.exit(1);
    }


    public void rateLimitThresholdBreached() {
        System.out.println("Rate Limit has been breached for: ");
    }
    public void rateLimitThresholdNormal() {
        System.out.println("Rate Limit is under control for: ");
    }
}
