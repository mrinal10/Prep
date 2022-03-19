package important450.linkedlist;

public class DetectLoop {
    public static boolean detectLoop(ListNode head){

        ListNode hare = head;
        ListNode tortoise = head;

        while(hare!=null && hare.next!=null && hare.next.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if(hare==tortoise) {
                return true;
            }
        }
        return false;
    }
}
