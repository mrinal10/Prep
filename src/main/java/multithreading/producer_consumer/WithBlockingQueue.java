package multithreading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerImpl implements Runnable {

    private final BlockingQueue<Integer> queue;
    private volatile int index;

    public ProducerImpl(BlockingQueue q, int ii){
        queue = q;
        index = ii;
    }

    @Override
    public void run() {
        synchronized(this) {
            while (true) {
                try {
                    queue.put(index);
                    System.out.println("Produced by " + Thread.currentThread().getName() + " with index " + index);
                    index++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ConsumerImpl implements Runnable {

    BlockingQueue<Integer> queue;

    ConsumerImpl(BlockingQueue<Integer> q) {
        queue = q;
    }

    int taken = -1;
    @Override
    public void run() {
        while (true) {
            try {
                taken = queue.take();
                System.out.println("Consumed :"+taken);
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class WithBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<>(3);
        int productionIndex = 0;
        ProducerImpl p1 = new ProducerImpl(bQueue, productionIndex);
        ConsumerImpl c1 = new ConsumerImpl(bQueue);

        Thread producerThread = new Thread(p1, "producer_1");
        Thread producerThread2 = new Thread(p1, "producer_2");
        Thread consumerThread = new Thread(c1);

        producerThread.start();
        producerThread2.start();
        consumerThread.start();
    }
}
