package important450;

import java.util.Stack;

import important450.tree.Node;

public class IterativeTreeTraversal {

    void inorder(Node root) {
        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || stack.size() > 0) {

            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.data);
            cur = cur.right;
        }

    }
    
}
