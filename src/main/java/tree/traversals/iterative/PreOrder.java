package tree.traversals.iterative;

import java.util.Stack;
import tree.Node;

public class PreOrder {

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.data);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
