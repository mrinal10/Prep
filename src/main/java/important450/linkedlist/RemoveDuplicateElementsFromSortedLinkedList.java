package important450.linkedlist;

public class RemoveDuplicateElementsFromSortedLinkedList {
    ListNode removeDuplicates(ListNode head) {

        ListNode cur = head;
        while(cur!=null) {
            while(cur.next!=null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
