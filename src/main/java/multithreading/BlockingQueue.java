package multithreading;

class Node<T> {

    private T data;
    private Node nextNode;

    Node(T d) {
        data = d;
        nextNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

public class BlockingQueue<T> {
    private Node front;
    private Node rear;
    private int length;

    public synchronized void put(T data) throws InterruptedException {
        System.out.println("put method called...");
        if(this.length > 9){
            System.out.println("Maximum capacity reached. Hence waiting for take() operation");
            wait();
        }
        Node node = new Node(data);
        if(isEmpty()){
            front = node;
        }else {
            rear.setNextNode(node);
        }
        rear = node;
        length++;
        System.out.println("Data added in the queue. Going to notify the observers.");
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        System.out.println("take() method called");
        T data;
        if(isEmpty()){
            System.out.println("No data found in the queue. take()() method execution paused.");
            wait();
        }
        System.out.println("Data became available. take() method resumed.");
        data = (T) front.getData();
        front = front.getNextNode();
        length--;
        return data;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue();

            new Thread(() -> {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


            new Thread(() -> {
                try {
                    queue.put(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

    }
}
