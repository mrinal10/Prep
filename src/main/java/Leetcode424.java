public class Leetcode424 {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int[] charCounts = new int[26];
        int windowStart = 0;
        
        for(int windowEnd=0; windowEnd<s.length(); windowEnd++){
            charCounts[s.charAt(windowEnd) - 'A']++;
            int currentCharCount = charCounts[s.charAt(windowEnd) - 'A'];
            maxCount = Math.max(maxCount, currentCharCount);
            int windowSize = windowEnd - windowStart + 1;

            while( maxCount + k < windowSize ) { //out of ops 
                charCounts[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}
