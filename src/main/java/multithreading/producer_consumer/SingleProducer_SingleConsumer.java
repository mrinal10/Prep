package multithreading.producer_consumer;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{
    private List<String> buffer;

    public Producer(List<String> buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        int i = 1;
        while(true) {
            buffer.add(i+"");
            i++;
            System.out.println(Thread.currentThread().getName()+" added "+i);
        }
    }
}

class Consumer implements Runnable{
    private List<String> buffer;

    public Consumer(List<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true){
            if (buffer.isEmpty()){
                continue;
            }
            if (buffer.get(0).equals(Driver.EOF)){
                System.out.println(Thread.currentThread().getName()+" exiting.");
                break;
            } else {
                System.out.println(Thread.currentThread().getName()+ " removed " +buffer.remove(0));
            }
        }
    }
}


class Driver {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();

        Thread producerThread = new Thread(new Producer(buffer));
        producerThread.setName("producerThread");

        Thread consumerThread1 = new Thread(new Consumer(buffer));
        consumerThread1.setName("consumerThread1");

        Thread consumerThread2 = new Thread(new Consumer(buffer));
        consumerThread2.setName("consumerThread2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
