package important450.dynamic_programming;

public class Knapsack_0_1 {

    //DP approach
    static int knapSackDp(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];

        for (int i=0; i<=n; i++) {
            for(int j=0; j<=W; j++) {

                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max( val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j] );
                }
            }
        }
        return dp[n][W];
    }

    //recursive approach
    static int knapSack(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

        else
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                                         knapSack(W, wt, val, n - 1));
    }
}
