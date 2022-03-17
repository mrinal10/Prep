package adhoc;

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char popped = stack.pop();
                if((c==')' && popped != '(')
                        || (c=='}' && popped != '{')
                        || (c==']' && popped != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
