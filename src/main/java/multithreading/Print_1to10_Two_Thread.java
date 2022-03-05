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
                    try {
                        System.out.println("Odd Print:"+counter);
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    counter++;
                    notifyAll();
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
                    try {
                        System.out.println("Even Print:"+counter);
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    counter++;
                    notifyAll();
                }
            }
        }

        public static void main(String[] args) {
            N = 100;
            Print_1to10_Two_Thread mt = new Print_1to10_Two_Thread();

            Thread oddThread = new Thread(mt::printEvenNumber);

            Thread evenThread = new Thread(mt::printOddNumber);

            oddThread.start();
            evenThread.start();
        }
    }
