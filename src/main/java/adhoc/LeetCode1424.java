package adhoc;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode1424 {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0]+a[1]!=b[0]+b[1]) return (a[0]+a[1]) - (b[0]+b[1]);
            else {
                return a[1] - b[1];
            }
        });
        int idx = 0, size = 0;
        for (int i = 0; i<nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j<list.size(); j++) {
                pq.add(new int[]{i, j, list.get(j)});
            }
            size+=list.size();
        }
        int [] res = new int[size];
        while (pq.size()>0) {
            res[idx] = pq.poll()[2];
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1,2,3,4,5);
        List<Integer> l2 = List.of(6,7);
        List<Integer> l3 = List.of(8);//
        List<Integer> l4 = List.of(9,10,11);
        List<Integer> l5 = List.of(12,13,14,15,16);

        List<List<Integer>> l = List.of(l1, l2, l3, l4, l5);
        int[] arr = findDiagonalOrder(l);
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }
}
