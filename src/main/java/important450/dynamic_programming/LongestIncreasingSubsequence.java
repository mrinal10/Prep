package important450.dynamic_programming;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {

    static int lis(int arr[], int n) {
       if(n==0 || n==1) {
           return n;
       }
       Set<Integer> set = new TreeSet();
       for(int i =0; i<n; i++) {
           set.add(arr[i]);
       }
       int m = set.size();
       int[] ar2 = new int[m];
       int i=0;
       for (int v : set) {
           ar2[i] = v;
           i++;
       }
       int[][] dp = new int[n+1][m+1];

       for(i=1; i<=n; i++) {
           for(int j=1; j< m; j++) {
               if(arr[i]==ar2[j]) {
                  dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
           }
       }
       return dp[n][m];
    }
}
