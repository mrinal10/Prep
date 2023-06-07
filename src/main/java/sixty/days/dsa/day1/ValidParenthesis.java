package sixty.days.dsa.day1;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {

        Stack<Character> charStack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(c=='{' || c == '[' || c == '(') {
                charStack.add(c);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }
                char top = charStack.peek();
                if (c == ')'){
                    if (top != '(') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                } else if (c == '}') {
                    if (top != '{') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                } else if(c==']') {
                    if (top != '[') {
                        return false;
                    } else {
                        charStack.pop();
                    }
                }
            }
        }
        return charStack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "(]";
        ValidParenthesis validParenthesis = new ValidParenthesis();
        validParenthesis.isValid(s);
    }
}
