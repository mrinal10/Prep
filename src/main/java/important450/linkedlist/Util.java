package important450.linkedlist;

public class Util {

    public static void printList(ListNode head) {

        if(head==null) {
            return;
        }

        ListNode cur = head;
        while(cur!=null) {
            if(cur.next==null)
                System.out.print(cur.val);
            else
                System.out.print(cur.val+" -> ");

            cur = cur.next;
        }
    }
}
