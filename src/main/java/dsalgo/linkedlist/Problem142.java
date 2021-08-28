package dsalgo.linkedlist;

import java.util.LinkedList;

public class Problem142 {
    private ListNode head;

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow!= null
                && fast!= null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                return getStartNode(slow, head);
            }
        }
        return null;
    }

    public ListNode getStartNode(ListNode loop, ListNode head) {
        ListNode ptr1 = loop;
        ListNode ptr2 = loop;
        int loopLength = 0;
        while(ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            loopLength++;
        }
        ptr1 = head;
        ptr2 = head;
        while (loopLength-->0) {
            ptr2 = ptr2.next;
        }
        while(ptr1!=ptr2) {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        Problem142 list = new Problem142();
        list.head = new ListNode(50);
        list.head.next = new ListNode(20);
        list.head.next.next = new ListNode(15);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(10);

        list.head.next.next.next.next.next = list.head.next.next;
        list.detectCycle(list.head);
    }

}
