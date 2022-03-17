package important450.tree.traversals.recursive;

import important450.tree.Node;

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
