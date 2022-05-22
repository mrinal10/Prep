package amazon;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int lengthLongestSubstring = 1;
        String palindromicSubstring = "";

        for(int i=0; i<s.length(); i++) {
            int x = i;
            int y = i + 1;
            int plaindromeLen = 0;
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)) {
                x--;
                y++;
                plaindromeLen += 2;
            }
            lengthLongestSubstring = Math.max(lengthLongestSubstring, plaindromeLen);
            if(plaindromeLen == lengthLongestSubstring)
                palindromicSubstring =s.substring(x+1, y);


            x = i - 1;
            y = i + 1;
            plaindromeLen = 1;
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)) {
                x--;
                y++;
                plaindromeLen += 2;
            }
            lengthLongestSubstring = Math.max(lengthLongestSubstring, plaindromeLen);
            if(plaindromeLen == lengthLongestSubstring)
                palindromicSubstring = s.substring(x+1, y);

        }

        return palindromicSubstring;
    }

    public static void main(String[] args) {
        String s = "babad";

        LongestPalindromicSubstring longest = new LongestPalindromicSubstring();
        System.out.println(longest.longestPalindrome(s));
    }
}
