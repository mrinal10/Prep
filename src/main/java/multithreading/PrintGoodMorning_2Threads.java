package multithreading;

class PrinterTask implements Runnable {

    private Print print;
    private boolean isEvenNumber;

    PrinterTask(Print p, boolean isEven) {
        print = p;
        isEvenNumber = isEven;
    }

    @Override
    public void run() {
        while (true) {
            if (isEvenNumber) {
                print.printGood();
            } else {
                print.printMorning();
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) { }
        }
    }
}

class Print {
    private volatile boolean isOdd;

    public synchronized void printGood() {

        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.err.println(Thread.currentThread().getName());
        isOdd = !isOdd;
        notifyAll();
    }

    public synchronized void printMorning() {

        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.err.print(Thread.currentThread().getName());
        isOdd = !isOdd;
        notifyAll();
    }
}

public class PrintGoodMorning_2Threads {

    public static void main(String[] args) {
        Print print = new Print();
        Thread t1 = new Thread(new PrinterTask(print, false),"Good ");
        Thread t2 = new Thread(new PrinterTask(print, true),"Morning");
        t1.start();
        t2.start();
    }
}
