package design.ratelimiter;

/**
 * Listener interface’s implementation to receive the threshold
 * breach notifications. Application may take appropriate action
 * after receiving this callback
 */
public class RateLimitThrottleListener implements RateLimitListener {
    public RateLimitThrottleListener() { }

    public void rateLimitThresholdBreached() {
        System.out.println("Received threshold breach callback notification");
    }
}