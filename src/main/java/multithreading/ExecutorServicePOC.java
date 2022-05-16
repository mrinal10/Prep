package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicePOC {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService fixedThreadPoolExecutorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> callableTasks = new ArrayList<>();
        int numberOfThreads = 5000;
        while (numberOfThreads-- > 0) {
            Callable<String> callableTask = () -> {
                MySingleton mySingleton = MySingleton.getObject();
                return ("hashMap : " + mySingleton.hashCode());
            };
            callableTasks.add(callableTask);
        }

        List<Future<String>> futures = fixedThreadPoolExecutorService.invokeAll(callableTasks);

        for(Future<String> future : futures) {
            System.out.println("futures : "+future.get());
        }

        fixedThreadPoolExecutorService.shutdown();
    }
}
