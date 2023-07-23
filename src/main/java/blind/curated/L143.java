package blind.curated;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class L143 {

    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;

        //reach the mid of list
        ListNode mid=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            mid=mid.next;
            fast=fast.next.next;
        }

        ListNode otherHead = mid.next;
        mid.next = null;
        mergeList(head, otherHead);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode head = a;
        a = a.next;
        while(a!=null) {
            cur.next = b;
            cur = cur.next;
            cur.next = a;
            a = a.next;
            b = b.next;
        }
        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;

        while(cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);



        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        L143 l143 = new L143();
        l143.reorderList(n1);
        ListNode cur = n1;

        while(cur!=null) {
            System.out.print(cur.val + " ->");
        }
    }
}
