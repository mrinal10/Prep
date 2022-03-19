package important450.linkedlist;

public class Reverse_iterative {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }
}
