package important450.linkedlist;

public class Reverse_recursive {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode newHead = reverseList(head.next);
        head.next = null;
        ListNode cur = newHead;

        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }


}
