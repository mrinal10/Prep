package important450.linkedlist;

public class DeleteLoop {
    public static void removeLoop(ListNode loopStart, ListNode head) {
        ListNode ptr1 = loopStart;
        ListNode ptr2 = loopStart;
        int loopLength = 1;
        while (ptr1.next != ptr2) {
            loopLength++;
            ptr1 = ptr1.next;
        }

        ptr1 = head;
        ptr2 = head;
        for (int i=0; i<loopLength; i++) {
            ptr2 = ptr2.next;
        }

        while(ptr2!=ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2.next = null;
    }
    public static boolean detectLoop(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare!=null && hare.next!=null && hare.next.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if(hare==tortoise) {
               removeLoop(hare, head);
               return true;
            }
        }
        return false;
    }
}
