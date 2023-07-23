package blind.curated;

public class L91 {
    public int numDecodings(String s) {
        final int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // ""
        dp[n - 1] = s.charAt(n - 1)!='0' ? 1 : 0;

        for (int i = n - 2; i >= 0; --i) {
            char c = s.charAt(i);
            if (c!='0')
                dp[i] += dp[i + 1];
            if (isValid(c, s.charAt(i + 1)))
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }

    private boolean isValid(char c1, char c2) {
        return c1 == '1' || c1 == '2' && c2 < '7';
    }

    public static void main(String[] args) {
        L91 l91 = new L91();
        System.out.println(l91.numDecodings("06"));
    }
}
