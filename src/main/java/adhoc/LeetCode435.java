package adhoc;

import java.util.*;

public class LeetCode435 {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public boolean isOverlapping(int[] i, int[] j) {
        return i[1] > j[0];
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                    break;
                }
            }
            dp[i] = Math.max(max + 1, dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;
    }

    public static void main(String[] args) {
        int[][] ar = {{1,2}, {1,2}, {1,2}};
        LeetCode435 l435 = new LeetCode435();
        System.out.println(l435.eraseOverlapIntervals(ar));
    }
}
