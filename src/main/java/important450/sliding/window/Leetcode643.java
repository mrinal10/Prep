package important450.sliding.window;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThread {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(new Thread());
        executor.shutdown();
    }


    static class Thread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println( " Completed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}