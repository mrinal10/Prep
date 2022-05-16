package design.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * This is a thread safe static singleton class which maintains all
 * the rate limiting policies in the form of a concurrent hash map.
 * The key of the map is the instance id while the value is the Rate
 * Limit Executor object.
 * Based on the key supplied the appropriate Rate Limiter is invoked.
 */
public final class RateLimitManager {

    public static final RateLimitManager _instance = new RateLimitManager();

    private ConcurrentHashMap <String, RateLimitExecutor> rateLimitMap = new ConcurrentHashMap<String, RateLimitExecutor>();

    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void provisionRateLimit(RateLimitExecutor builder, String instance_id, RateLimitListener listener) {
        builder.setListener(listener);
        rateLimitMap.put(instance_id, builder);
    }

    public void deProvisionRateLimit (String instance_id) {
        try {
            rateLimitMap.remove(instance_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pegTraffic(String instance_id) {
        rateLimitMap.get(instance_id).evaluate();
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
}