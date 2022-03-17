package tree;

public class CheckIfTreeBalanced {
    boolean isBalanced(Node root) {

        if(root == null) {
            return true;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return (Math.abs(lHeight - rHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right));
    }

    int height(Node root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
