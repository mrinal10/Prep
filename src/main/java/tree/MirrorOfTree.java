package tree;

public class MirrorOfTree {

    static Node mirrorify(Node root) {

        if(root == null) {
            return null;
        }

        Node newNode = createNode(root.data);
        newNode.left = mirrorify(root.right);
        newNode.right = mirrorify(root.left);

        return newNode;
    }

    static Node createNode(int v) {

        Node root = new Node(v);
        return root;
    }
}
