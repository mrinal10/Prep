package important450.dynamic_programming;

import java.util.Locale;

public class EditDistance {
    public int editDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1+1][len2+1];

        for (int i=0; i <= len1; i++) {
            for(int j=0; j<=len2; j++) {

                if(i==0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
            }
        }
        return dp[len1][len2];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";

        EditDistance ed = new EditDistance();
        System.out.println(ed.editDistance(str1, str2));
    }
}
