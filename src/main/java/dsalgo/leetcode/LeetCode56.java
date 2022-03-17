package dsalgo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Interval implements Comparable<Interval>{
    int start, end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Interval o) {
        if(this.start == o.start)
            return 0;
        else if(this.start < o.start)
            return -1;
        else
            return 1;
    }
}

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {

        List<Interval> intervalList = new ArrayList<>();
        for (int[] ints : intervals) {
            Interval interval = new Interval(ints[0], ints[1]);

            intervalList.add(interval);
        }
        Stack<Interval> filteredList = new Stack<>();
        Collections.sort(intervalList);

        for (Interval currInterval : intervalList) {
            if(filteredList.isEmpty()) {
                filteredList.add(currInterval);
            } else {
                Interval stackTop = filteredList.pop();
                if(stackTop.end >= currInterval.start) {
                    if(currInterval.end >= stackTop.end) {
                        stackTop.end = currInterval.end;
                    }
                    filteredList.add(stackTop);
                } else {
                    filteredList.add(stackTop);
                    filteredList.add(currInterval);
                }
            }
        }

        int len = filteredList.size();
        int[][] ans = new int[len][2];

        List<Interval> ll = new ArrayList();
        while(!filteredList.isEmpty()) {
            ll.add(filteredList.pop());
        }
        Collections.reverse(ll);
        for(int i=0; i<ll.size(); i++) {
            ans[i][0] = ll.get(i).start;
            ans[i][1] = ll.get(i).end;
        }

        return ans;
    }
}
