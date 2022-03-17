package tree.traversals;

import java.util.ArrayList;
import tree.Node;

public class BoundaryTraversal {
    ArrayList<Integer> ans;

    ArrayList<Integer> boundary(Node node) {
        if(node == null)
            return null;

        ans = new ArrayList<>();
        ans.add(node.data);

        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printBoundaryRight(node.right);
        return ans;
    }

    void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);
        if (node.left == null && node.right == null)
            ans.add(node.data);
        printLeaves(node.right);
    }

    void printBoundaryLeft(Node node) { // top to bottom
        if (node == null)
            return;

        if (node.left != null) {
            ans.add(node.data);
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            ans.add(node.data);
            printBoundaryLeft(node.right);
        }
    }

    void printBoundaryRight(Node node) { //bottom to top
        if (node == null)
            return;

        if (node.right != null) {
            printBoundaryRight(node.right);
            ans.add(node.data);
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            ans.add(node.data);
        }
    }
}
