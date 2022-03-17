package adhoc;

import java.util.HashMap;
import java.util.Map;

public class LCS {
    static int lcs(int m, int n, String s1, String s2) {
        Map<String, Integer> lookup = new HashMap<String, Integer>();
        //return lcsOptimized(m-1, n-1, s1, s2, lookup);
        return lcsDp(m, n, s1, s2);
    }

    static int lcsDp(int m, int n, String s1, String s2) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[m][n];
    }

    static int lcsOptimized(int m, int n, String s1, String s2,
            Map<String, Integer> lookup) {
        if (m < 0 || n < 0) {
            return 0;
        }

        String key = m + "}" + n;

        if (!lookup.containsKey(key)) {
           if (s1.charAt(m) == s2.charAt(n)) {
                lookup.put(key, 1 + lcsOptimized(m - 1, n - 1, s1, s2, lookup));
            } else {
                lookup.put(key,
                        Math.max(lcsOptimized(m - 1, n, s1, s2, lookup),
                            lcsOptimized(m, n - 1, s1, s2, lookup)));
            }
        }
        return lookup.get(key);
    }

    static int lcsUtil(int m, int n, String s1, String s2) {
        if(m<0 || n<0) {
            return 0;
        }

        if(s1.charAt(m)==s2.charAt(n)) {
            return 1 + lcsUtil(m-1, n-1, s1, s2);
        }

        return Math.max(lcsUtil(m-1, n, s1, s2), lcsUtil(m, n-1, s1, s2));
    }
}
