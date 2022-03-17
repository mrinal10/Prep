package gfg.ds.algo;

import java.util.Stack;

public class PostfixEvaluation {
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] ar = S.toCharArray();

        for(int i=0; i<ar.length; i++) {
            char c = ar[i];

            if(isNumber(c) ) {
                stack.push(Integer.parseInt(c+""));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        if(stack.size()>1) {
            return -1;
        }
        return stack.pop();
    }

    private static boolean isNumber(char c) {
        try {
            int n = Integer.parseInt(c+"");
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "231*+9-";
        evaluatePostFix(s);
    }
}
