package multithreading;


class TaskEvenOdd implements Runnable {
    private Printer print;
    private boolean isEvenNumber;

    TaskEvenOdd(Printer p, boolean isEven) {
        print = p;
        isEvenNumber = isEven;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (true) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            number += 2;
        }
    }
}

class Printer {
    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}

public class PrintEvenOdd {

    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, false),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, true),"Even");
        t1.start();
        t2.start();
    }
}
