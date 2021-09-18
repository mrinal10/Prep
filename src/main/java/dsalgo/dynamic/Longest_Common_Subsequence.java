package dsalgo.dynamic;

public class Longest_Common_Subsequence {

    static int lcs(char[] ar1, char[] ar2) {
        int len1 = ar1.length;
        int len2 = ar2.length;

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i<=len1; i++) {
            for(int j=0; j<=len2; j++) {

                if(i==0 || j==0) {
                   dp[i][j] = 0;
                } else if(ar1[i-1] == ar2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] ar1 = s1.toCharArray();
        char[] ar2 = s2.toCharArray();

        System.out.println(lcs(ar1, ar2));
    }

}
