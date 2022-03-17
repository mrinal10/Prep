package tree.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import tree.Node;

public class Diagonal {
    static TreeMap<Integer, List<String>> output;
    static final TreeMap<Integer, List<String>> diagonalPrint(Node root) {

        output = new TreeMap();
        diagonalPrintUtil(root, 0);
        return output;
    }

    static void diagonalPrintUtil(Node root, int level) {

        if(root == null) {
            return;
        }

        List<String> ll = new ArrayList();
        if(output.containsKey(level)) {
            ll = output.get(level);
        }
        ll.add(root.data+" ");
        output.put(level, ll);
        diagonalPrintUtil(root.left, level + 1);
        diagonalPrintUtil(root.right, level);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        TreeMap<Integer, List<String>> printArray = diagonalPrint(root);

        for(Map.Entry<Integer, List<String>> entry : printArray.entrySet()) {
            List<String> values = entry.getValue();

            values.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
