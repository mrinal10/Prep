package important450.linkedlist;

public class MiddleOfList {
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next!=null) {
            slow = slow.next;
        }
        return slow;
    }
}
