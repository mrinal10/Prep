package important450.linkedlist;

public class AddTwoNumbers {
    static ListNode addTwoLists(ListNode first, ListNode second){
        if(first == null)
            return second;
        if(second == null)
            return first;

        first = reverseList(first);
        second = reverseList(second);

        ListNode ff = first.next;
        ListNode ss = second.next;

        int v = first.val + second.val;
        int remainder = v % 10;
        v = v / 10;
        ListNode newHead = new ListNode(first.val + second.val);
        ListNode curr = newHead;
        while(ff!=null && ss!=null) {
            v = ff.val + remainder + ss.val;
            remainder = v % 10;
            v = v / 10;
            curr.next = new ListNode(v);
            curr = curr.next;
            ff = ff.next;
            ss = ss.next;
        }

        while(ff!=null) {
            v = ff.val + remainder;
            remainder = v % 10;
            v = v / 10;
            curr.next = new ListNode(v);
            ff = ff.next;
        }

        while(ss!=null) {
            v = remainder + ss.val;
            remainder = v % 10;
            v = v / 10;
            curr.next = new ListNode(v);
            ss = ss.next;
        }
        if(remainder > 0) {
            curr.next = new ListNode(remainder);
        }
        newHead = reverseList(newHead);

        return newHead;
    }

    static ListNode reverseList(ListNode head) {

        if(head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur!=null) {

            next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = cur.next;
        }
        return prev;
    }
}
