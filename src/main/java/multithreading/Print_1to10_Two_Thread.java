package multithreading;

public class Print_1to10_Two_Thread {
        int counter = 1;
        static int N;

        public void printOddNumber() {
            synchronized (this) {
                while (counter < N) {
                    while (counter % 2 == 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd Print:"+counter);
                    counter++;
                    notify();
                }
            }
        }

        public void printEvenNumber() {
            synchronized (this) {
                while (counter < N) {
                    while (counter % 2 == 1) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even Print:"+counter);
                    counter++;
                    notify();
                }
            }
        }

        public static void main(String[] args) {
            N = 10;
            Print_1to10_Two_Thread mt = new Print_1to10_Two_Thread();

            Thread oddThread = new Thread(new Runnable() {
                public void run() {
                    mt.printEvenNumber();
                }
            });

            Thread eventThread = new Thread(new Runnable() {
                public void run() {
                    mt.printOddNumber();
                }
            });

            oddThread.start();
            eventThread.start();
        }
    }
