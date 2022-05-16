package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrant {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            assertEquals(1, reentrantLock.getHoldCount());
            assertEquals(true, reentrantLock.isLocked());
        } finally {
            reentrantLock.unlock();
            assertEquals(0, reentrantLock.getHoldCount());
            assertEquals(false, reentrantLock.isLocked());
        }
    }

    private static boolean assertEquals(int i, int holdCount) {
        return (i==holdCount);
    }

    private static boolean assertEquals(boolean i, boolean holdCount) {
        return (i==holdCount);
    }
}
