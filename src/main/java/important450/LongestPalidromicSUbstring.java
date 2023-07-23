package important450;

public class LongestPalidromicSUbstring {

    public String longestPalindrome(String s) {

        String longestPalindrome = "";
        int longestPalindromeLength = 0;
        int x = 0;
        int y = 0;
        int length = 0;
        for(int i=0; i<s.length(); i++) {
            //for even
            x = i;
            y = i+1;
            length = 0;
            while(x >= 0 && y < s.length() && s.charAt(x)==s.charAt(y)) {
                length = y - x + 1;
                x--;
                y++;
            }
            if(length > longestPalindromeLength) {
                longestPalindromeLength = length;
                longestPalindrome = s.substring(x+1, y);
            }


            //if odd
            x = i-1;
            y = i+1;
            length = 1;
            while(x >= 0 && y < s.length() && s.charAt(x)==s.charAt(y)) {
                length = y - x + 1;
                x--;
                y++;
            }
            if(length > longestPalindromeLength) {
                longestPalindromeLength = length;
                longestPalindrome = s.substring(x+1, y);
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s = "b";//abad";
        LongestPalidromicSUbstring lps = new LongestPalidromicSUbstring();
        System.out.println(lps.longestPalindrome(s));
    }
}
