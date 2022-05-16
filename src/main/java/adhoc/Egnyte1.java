package adhoc;

import java.util.Stack;

public class Egnyte1 {
    public static int solution(String S) {
        String[] inputArray = S.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        for(String input : inputArray) {
            if(input.equals("DUP")) {
                Integer top = stack.peek();
                stack.push(top);
            } else if(input.equals("POP")) {
                stack.pop();
            } else if(input.equals("+")) {
                Integer f =-1;
                Integer s = -1;
                if(!stack.isEmpty()) {
                    f = stack.pop();
                } else {
                    return -1;
                }
                if(!stack.isEmpty()) {
                    s = stack.pop();
                } else {
                    return -1;
                }
                Integer ans = s+f;
                stack.push(ans);
            } else if(input.equals("-")) {
                Integer f = -1;
                Integer s = -1;
                if(!stack.isEmpty()) {
                    f = stack.pop();
                } else {
                    return -1;
                }
                if(!stack.isEmpty()) {
                    s = stack.pop();
                } else {
                    return -1;
                }
                Integer ans = f-s;
                stack.push(ans);
            } else {
                Integer bd = Integer.valueOf(input);
                stack.push(bd);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String inpu = "1048575 DUP +";
        System.out.println(Egnyte1.solution(inpu));
    }
}
