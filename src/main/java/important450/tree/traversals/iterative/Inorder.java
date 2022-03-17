package important450.tree.traversals.iterative;

import java.util.Stack;
import important450.tree.Node;

public class Inorder {
    public static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();

        Node cur = root;

        while (cur != null || stack.isEmpty()) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.data);
                cur = cur.right;
            }
        }
    }
}
