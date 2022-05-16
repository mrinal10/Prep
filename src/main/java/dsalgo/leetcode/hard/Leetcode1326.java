package dsalgo.leetcode.hard;

public class Leetcode1326 {

    public int minTaps(int n, int[] ranges) {
        if (n == 0 || ranges.length == 0)
            return n == 0 ? 0 : -1;
        int[] modifiedRange = new int[n + 1];

        int nxtLargest = 0, current = 0;
        int ans = 0;

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > 0) { //for valid range
                int index = Math.max(0, i - ranges[i]);
                modifiedRange[index] = Math.max(modifiedRange[index], i + ranges[i]);
            }
        }

        for (int i = 0; i <= n; i++) {
            nxtLargest = Math.max(nxtLargest, modifiedRange[i]);
            if (i == current && i < n) {
                current = nxtLargest;
                ans++;
            }
            if (current < i) {
                return -1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] range = {3,4,1,1,0,0};
        Leetcode1326 leetcode1326 = new Leetcode1326();
        System.out.println(leetcode1326.minTaps(5, range));
    }
}