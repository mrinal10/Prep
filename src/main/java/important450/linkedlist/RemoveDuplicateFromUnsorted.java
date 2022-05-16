package important450.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateFromUnsorted {
    public ListNode removeDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ListNode cur = head;
        while(cur!=null) {
            int key = cur.val;
            int value = 0;
            if(frequencyMap.containsKey(key)) {
                value = frequencyMap.get(key);
            }
            value++;
            frequencyMap.put(key, value);
            cur = cur.next;
        }

        cur = head;
        ListNode nextNode = head.next;
        while(cur.next!=null) {

            int key = nextNode.val;
            int freq = frequencyMap.get(key);
            if(freq > 1) {
                freq -= 1;
                frequencyMap.put(key, freq);

                cur.next = nextNode.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);

        head.next = first;
        first.next = second;
        second.next = third;
        RemoveDuplicateFromUnsorted removal = new RemoveDuplicateFromUnsorted();
        head = removal.removeDuplicates(head);

        Util.printList(head);
    }
}
