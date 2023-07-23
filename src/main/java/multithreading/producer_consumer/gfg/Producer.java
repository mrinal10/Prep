package multithreading.producer_consumer.gfg;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue<Integer> obj;

    public Producer(BlockingQueue<Integer> obj)
    {
        // accept an ArrayBlockingQueue object from
        // constructor
        this.obj = obj;
    }

    @Override
    public void run()
    {

        // Produce numbers in the range [1,4]
        // and put them in the buffer
        for (int i = 1; ; i++) {
            try {
                obj.put(i);
                System.out.println("Produced " + i);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
