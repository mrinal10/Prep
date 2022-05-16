package dsalgo.leetcode.hard;

import java.util.Stack;

public class LeetCode32_hard {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        LeetCode32_hard leetCode32 = new LeetCode32_hard();
        System.out.println(leetCode32.longestValidParentheses(s));
    }
}
