package design.ratelimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/**
 *
 * @author aayush
 * This class calculates the TPS and applies the throttling policy
 * It uses granular write locking for thread safety.
 */
public class RateLimitExecutor {
    private TimeUnit timeUnit;
    private long transactions = 0L;
    private long threshold;
    private long tps;
    private String instance_id;
    private double timeStamp;
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private WriteLock wLock = rwLock.writeLock();


    private RateLimitListener listener;
    public RateLimitExecutor() {
        this.timeStamp = System.currentTimeMillis();
    }
    public void setInstanceID(String instance_id) {
        this.instance_id = instance_id;
    }

    public void evaluate() {
        System.out.println("Starting Rate Limit evaluation\n" + "Threshold set is: "+threshold);
        ++transactions;
        wLock.lock();
        double currentTime = System.currentTimeMillis();
        double deltaTime = currentTime - timeStamp;
        System.out.println("Delta time elapsed: "+deltaTime);

        tps = (long) (transactions/deltaTime * 1000L);

        if(transactions != 1)
            System.out.println("TPS is — "+ tps);

        if(tps >=threshold && transactions !=1) {
            System.out.println("Rate limit has been breached, Transaction Number: "+transactions+
" in delta time (milliseconds): "+ deltaTime +
" Threshold: " +threshold);
            RateLimitManager._instance.getThreadPool().execute(new WorkerThread(listener));
        }
        wLock.unlock();
    }
    public void build (TimeUnit time, long threshold) {
        this.timeUnit = time;
        this.threshold = threshold;
    }
    public void setListener (RateLimitListener listener) {
        this.listener = listener;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    public Long getTransactions() {
        return transactions;
    }
    public long getThreshold()  {
        return threshold;
    }
    public String getInstance_id() {
        return instance_id;
    }
    public void setInstance_id(String instance_id) {
        this.instance_id = instance_id;
    }
}