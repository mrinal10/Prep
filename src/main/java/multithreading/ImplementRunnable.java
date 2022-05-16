package multithreading;

public class ImplementRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        ImplementRunnable thread = new ImplementRunnable();
        Thread t1 = new Thread(thread);
        t1.start();
    }
}
