package multithreading.producer_consumer;

import java.util.LinkedList;

class Producer {
    LinkedList<Integer> jobList = new LinkedList<>();
    int capacity;

    Producer(LinkedList<Integer> jobList, int cap) {
        this.jobList = jobList;
        capacity = cap;
    }
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // producer thread waits while list
                // is full
                while (jobList.size() == capacity) {
                    notify();
                    wait();
                }

                System.out.println("Producer produced-" + value);

                // to insert the jobs in the list
                jobList.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to  understand
                Thread.sleep(1000);
            }
        }
    }
}

class Consumer {
    LinkedList<Integer> jobList = new LinkedList<>();

    Consumer(LinkedList<Integer> jobList) {
        this.jobList = jobList;
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (this) {
                // consumer thread waits while list
                // is empty
                while (jobList.size() == 0)
                    wait();

                // to retrieve the first job in the list
                int val = jobList.removeFirst();

                System.out.println("Consumer consumed-" + val);

                // Wake up producer thread
                notify();

                // and sleep
                Thread.sleep(1000);
            }
        }
    }
}


class Driver {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Integer> jobList = new LinkedList<>();
        int capacity = 2;
        Producer producer = new Producer(jobList, capacity);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Consumer consumer = new Consumer(jobList);
        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    consumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        c1.start();
    }

}
