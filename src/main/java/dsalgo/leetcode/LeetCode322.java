package dsalgo.leetcode;

import java.util.Arrays;

public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i=0; i<=amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        LeetCode322 l322 = new LeetCode322();
        System.out.println(l322.coinChange(coins, amount));
    }
}
