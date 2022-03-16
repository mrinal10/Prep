package dsalgo.leetcode;

public class LeetCode344 {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int start = i;
            int end = s.length - 1 - i;

            char temp = s[start];

            s[start] = s[end];
            s[end] = temp;
        }
    }
}