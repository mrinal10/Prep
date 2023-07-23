import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int ans = 0;
        int largestEndTillNow = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(largestEndTillNow <= intervals[i][0]) {
                largestEndTillNow = intervals[i][1];
            } else {
                ans++;
            }
        }
        return ans;
    }
}
