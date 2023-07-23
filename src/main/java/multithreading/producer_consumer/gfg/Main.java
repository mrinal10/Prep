package multithreading.producer_consumer.gfg;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        // Create an ArrayBlockingQueue object with capacity
        // 4
        BlockingQueue<Integer> bQueue
                = new ArrayBlockingQueue<Integer>(4);

        // Create 1 object each for producer
        // and consumer and pass them the common
        // buffer created above
        Producer p1 = new Producer(bQueue);
        Consumer c1 = new Consumer(bQueue, "c1");
        Consumer c2 = new Consumer(bQueue, "c2");
        // Create 1 thread each for producer
        // and consumer and pass them their
        // respective objects.
        Thread pThread = new Thread(p1);
        Thread cThread1 = new Thread(c1);
        Thread cThread2 = new Thread(c2);
        // Start both threads
        pThread.start();
        cThread1.start();
        cThread2.start();
    }
}
