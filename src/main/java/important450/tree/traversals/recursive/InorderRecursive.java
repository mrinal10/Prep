package important450.tree.traversals.recursive;

import important450.tree.Node;

public class InorderRecursive {
    public static void inorder(Node root) {

        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
