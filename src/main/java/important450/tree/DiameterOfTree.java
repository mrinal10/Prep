package important450.tree;

public class DiameterOfTree {

    int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int l_height = height(root.left);
        int r_height = height(root.right);

        int l_diam = diameter(root.left);
        int r_diam = diameter(root.right);

        int max_diam = l_height + 1 + r_height;
        return Math.max(Math.max(r_diam, l_diam), max_diam);
    }

    private int height(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
