package important450.linkedlist;

public class CopyListWithRandomPointers {

    public static RandomNode copyRandomList(RandomNode head) {

        RandomNode curr = head;
        RandomNode temp = null;

        while (curr != null) {
            temp = curr.next;

            curr.next = new RandomNode(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;



        return head;
    }

    public static void main(String[] args) {

    }
}
