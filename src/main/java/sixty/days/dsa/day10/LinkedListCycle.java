package sixty.days.dsa.day10;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && slow != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        if(slow == fast) {
            removeLoop(head, slow);
        }
        return false;
    }

    private void removeLoop(ListNode head, ListNode loopStartNode) {

        ListNode ptr1 = loopStartNode;

        // Count the number of nodes in loop
        ListNode prevNode = ptr1;
        while (ptr1.next != loopStartNode) {
            // keeping track beforeing moving next
            prevNode = ptr1;
            ptr1 = ptr1.next;
        }
        prevNode.next = null;
    }


}
