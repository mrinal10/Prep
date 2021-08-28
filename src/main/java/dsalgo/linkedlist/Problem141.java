package dsalgo.linkedlist;

class problem141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow!= null
                && fast!= null
                    && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}