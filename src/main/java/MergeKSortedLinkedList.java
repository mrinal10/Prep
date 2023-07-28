import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode cur = head;

        List<ListNode> listNodeList = new ArrayList<>();
        listNodeList = Arrays.asList(lists);
        System.out.println(listNodeList.size());

        while(!listNodeList.isEmpty()) {
            int leastIndex = 0;
            int leastValue = Integer.MAX_VALUE;
            
            for(int i=0; i<listNodeList.size(); i++) {
                if(leastValue > listNodeList.get(i).val) {
                    leastIndex = i;
                    leastValue = listNodeList.get(i).val;
                }
            }
            ListNode leastNode = listNodeList.get(leastIndex);
            listNodeList.remove(leastIndex);
            ListNode temp = new ListNode(leastValue, null);
            cur.next = temp;
            cur = cur.next;
            if(leastNode.next!=null) {
                listNodeList.add(leastIndex, leastNode.next);
            }
            
        }
        return head.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert two numbers : ");
        double n = sc.nextInt();
        double m = sc.nextInt();

        System.out.println("divided value is : " + n/m);
        sc.close();
    }



}
