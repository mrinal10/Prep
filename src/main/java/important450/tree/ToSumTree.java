package important450.tree;

public class ToSumTree {

    public void toSumTree(Node root){
        toSumTreeUtil(root);
    }

    int toSumTreeUtil(Node root) {
        if(root == null) {
            return 0;
        }

        int temp = toSumTreeUtil(root.left)
                + toSumTreeUtil(root.right);

        int value = root.data + temp;
        root.data = temp;

        return value;
    }
}
