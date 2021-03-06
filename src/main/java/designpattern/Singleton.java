package designpattern;

import multithreading.MySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Singleton {
    static Singleton singletonObject;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(singletonObject == null) {
            synchronized (Singleton.class) {
                if(singletonObject == null) {
                    singletonObject = new Singleton();
                }
            }
        }

        return singletonObject;
    }
}

class TestSingleton {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Callable<String>> callableTasks = new ArrayList<>();
        int numberOfThreads = 5000;
        while(numberOfThreads-- > 0) {
            Callable<String> callableTask = () -> {
                Singleton mySingleton = Singleton.getInstance();
                return ("hashcode : " + mySingleton.hashCode());
            };
            callableTasks.add(callableTask);
        }
        List<Future<String>> futures = executorService.invokeAll(callableTasks);

        for(Future<String> future : futures) {
            System.out.println("futures : "+future.get());
        }

    }
}
