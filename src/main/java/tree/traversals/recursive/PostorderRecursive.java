package tree.traversals.recursive;

import tree.Node;

public class PostorderRecursive {
    public static void inorder(Node root) {

        if(root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        System.out.println(root.data);
    }
}
