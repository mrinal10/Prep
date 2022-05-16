package multithreading;

public class NormalThread extends Thread {

    public void run() {
        System.out.println("System is running..");
    }

    public static void main(String[] args) {
        NormalThread nrmlThrd = new NormalThread();
        nrmlThrd.start();
    }
}
