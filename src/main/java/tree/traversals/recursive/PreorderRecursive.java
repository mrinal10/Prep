package tree.traversals.recursive;

import tree.Node;

public class PreorderRecursive {
    public static void inorder(Node root) {

        if(root == null) {
            return;
        }

        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);
    }
}
