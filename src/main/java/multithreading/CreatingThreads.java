package multithreading;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
    private final List<String> jobList;
    private final int limitOfJobs;
    Producer (List<String> jobList, int maxNumberOfJobs) {
        this.jobList = jobList;
        limitOfJobs = maxNumberOfJobs;
    }

    @Override
    public void run() {
        synchronized (this) {
            if(jobList.size() == limitOfJobs) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            jobList.add("created By "+Thread.currentThread().getName());
            System.out.println("JOb created :");
            notifyAll();
        }
    }
}

class Consumer implements Runnable {
    private final List<String> jobList;
    Consumer (List<String> jobList) {
        this.jobList = jobList;
    }

    @Override
    public void run() {
        synchronized (this) {
            if(jobList.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            jobList.add("created By "+Thread.currentThread().getName());
            System.out.println("JOb Consumed :");
            notifyAll();
        }
    }
}

public class CreatingThreads {

    public static void main(String[] args) {
        List<String> jobList = new ArrayList<>();
        int maxJobLimit = 200;

        Producer p = new Producer(jobList, maxJobLimit);
        Consumer c = new Consumer(jobList);

        Thread producer1 = new Thread(p);
        Thread consumer1 = new Thread(c);

        producer1.start();
        consumer1.start();
    }
}
