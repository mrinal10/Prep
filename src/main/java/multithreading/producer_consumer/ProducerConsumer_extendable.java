package multithreading.producer_consumer;

import multithreading.BlockingQueue;

class Message {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class QueueProducer implements Runnable {

    private final BlockingQueue<Message> dataQueue;
    private volatile boolean runFlag;

    public QueueProducer(BlockingQueue<Message> dQueue) {
        this.dataQueue = dQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        while (runFlag) {
            Message message = new Message();
            message.setData(100);
            if (!runFlag) {
                break;
            }
            try {
                dataQueue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        runFlag = false;
    }
}


public class ProducerConsumer_extendable {


}
