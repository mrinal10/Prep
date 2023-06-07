package sixty.days.dsa.day2;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }

        if(list2==null) {
            return list1;
        }

        ListNode head = null;
        ListNode next = null;
        if(list1.val < list2.val) {
            head = list1;
            next = list1;
            list1 = list1.next;
        } else {
            head = list2;
            next = list2;
            list2 = list2.next;
        }

        while(list1!=null && list2!=null) {
            if(list1.val < list2.val) {
                next.next = list1;
                list1 = list1.next;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }

        while(list1!=null){
            next.next = list1;
            list1 = list1.next;
            next = next.next;
        }

        while(list2!=null){
            next.next = list2;
            list2 = list2.next;
            next = next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(-9);
        ListNode l12 = new ListNode(3);
//        ListNode l14 = new ListNode(4);
        l11.next = l12;
//        l12.next = l14;

        ListNode l21 = new ListNode(5);
        ListNode l23 = new ListNode(7);
//        ListNode l24 = new ListNode(4);
        l21.next = l23;
//        l23.next = l24;

        MergeTwoSortedLists mergeLists = new MergeTwoSortedLists();
        mergeLists.mergeTwoLists(l11, l21);
    }
}
