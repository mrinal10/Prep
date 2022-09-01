package multithreading.producer_consumer;

import java.util.ArrayList;
import java.util.List;

//TODO need modification
public class ProducerConsumer {
    List<String> jobList = new ArrayList<>();
    int counter = 1;
    static int limit;

    public void produce() {
        synchronized (this) {
            if (jobList.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                String s = "produce "+counter;
                System.out.println("Produced : "+s);
                jobList.add(s);
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            counter++;
            notifyAll();
        }
    }

    public void consume() {
        synchronized (this) {
            if (jobList.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Removed : "+jobList.get(0));
                jobList.remove(0);
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            counter++;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        limit = 300;
        ProducerConsumer mt = new ProducerConsumer();

        Thread producer = new Thread(mt::produce);

        Thread consumer = new Thread(mt::consume);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
