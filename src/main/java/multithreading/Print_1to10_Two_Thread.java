package multithreading;

public class Print_1to10_Two_Thread {
    boolean isOdd;
    int start = 1;
    int endingLimit = 0;

    Print_1to10_Two_Thread(int limit) {
        endingLimit = limit;
    }

    public void printOdd() {
        synchronized (this) {
            while (start <= endingLimit) {
                while (!isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("By Odd thread : "+start);
            start++;
            isOdd = false;
            notify();
        }
    }

    public void printEven() {
        synchronized (this) {
            while (start <= endingLimit) {
                while (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("By Even thread : "+start);
            start++;
            isOdd = true;
            notify();
        }
    }

    public static void main(String[] args) {

        Print_1to10_Two_Thread printOddEven = new Print_1to10_Two_Thread(20);
        printOddEven.isOdd = false;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printOdd();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printEven();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
