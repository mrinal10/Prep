package dsalgo.leetcode.todo.jpmorgan;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ConvertBinaryNumber_1290 {
    public int getDecimalValue(ListNode head) {
        return recursiveLList(head, 0);
    }

    private int recursiveLList(ListNode head, int decimalPlace) {
        if(head == null) {
            return 0;
        }

        int value = recursiveLList(head.next, decimalPlace+1) +
                        (head.val*(int)Math.pow(2, decimalPlace));

        return value;
    }
}
