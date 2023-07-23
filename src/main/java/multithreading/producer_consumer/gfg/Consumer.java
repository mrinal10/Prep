package multithreading.producer_consumer.gfg;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Integer> obj;
    String name;

    int taken = -1;

    public Consumer(BlockingQueue<Integer> obj, String n) {
        this.obj = obj;
        name = n;
    }

    @Override public void run() {

        // Take numbers from the buffer and
        // print them, if the last number taken
        // is 4 then stop
        while (true) {
            try {
                taken = obj.take();
                System.out.println("Consumed by "+ name + ": " + taken);
                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
