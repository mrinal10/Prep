package dynamicprogramming;

//Longest Common Subsequence Problem
public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text2.toCharArray();
        char[] c2 = text1.toCharArray();

        int[][] dp = new int[c1.length+1][c2.length+1];

        for(int i=1; i<dp.length; i++) {
            char cc1 = c1[i-1];
            for (int j=1; j<dp[0].length; j++) {
                char cc2 = c2[j-1];
                if(cc1 == cc2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubsequence(s1,s2));
    }
}
