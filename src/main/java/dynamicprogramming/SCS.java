package dynamicprogramming;

//Shortest common super-sequence length
public class SCS {

    public int shortestCommonSupersequence(String str1, String str2) {
        return findLength(str1, str2, str1.length(), str2.length());
    }

    private int findLength(String s1, String s2, int m, int n) {

        if(m==0 || n==0) {
            return m+n;
        }

        if(s1.charAt(m) == s2.charAt(n)) {
            return findLength(s1, s2, m-1, n-1) + 1;
        } else {
            return Math.min(findLength(s1, s2, m-1, n), findLength(s1, s2, m, n-1));
        }
    }
}
