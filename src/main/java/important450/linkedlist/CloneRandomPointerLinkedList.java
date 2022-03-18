package important450.linkedlist;

public class CloneRandomPointerLinkedList {

    RandomNode copyList(RandomNode head) {
        RandomNode cur = head;

        while(cur!=null) {
            RandomNode newNode = new RandomNode(cur.val);
            newNode.next = cur.next;
            newNode.random = cur.random;
            cur.next = newNode;
            cur = cur.next.next;
        }

        cur = head;
        while(cur!=null) {
            cur.next.random = cur.next.random.next;
            cur = cur.next.next;
        }

        RandomNode newHead = head.next;
        cur = newHead;
        while(cur!=null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomNode head = new RandomNode(1);
        RandomNode one = new RandomNode(2);
        RandomNode two = new RandomNode(3);
        RandomNode three = new RandomNode(4);

        head.next = one;
        one.next = two;
        two.next = three;

        head.random = two;
        two.random = three;
        three.random = one;
        one.random = two;

        CloneRandomPointerLinkedList cpl = new CloneRandomPointerLinkedList();
        System.out.println("test");
    }
}
