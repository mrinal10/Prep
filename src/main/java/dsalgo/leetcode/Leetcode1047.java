package dsalgo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode1047 {

    public String removeDuplicates(String s) {

        Stack<Character> c = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {

            if(c.isEmpty()) {
                c.push(s.charAt(i));
            } else {
                Character cc = c.peek();
                if(cc == s.charAt(i)) {
                    c.pop();
                } else {
                    c.push(s.charAt(i));
                }
            }
        }

        char[] cc = new char[c.size()];
        for(int i=c.size()-1; i>=0; i--) {
            cc[i] = c.pop();
        }

        return String.valueOf(cc);
    }
}
