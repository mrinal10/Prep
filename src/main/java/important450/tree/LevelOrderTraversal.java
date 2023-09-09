package important450.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static ArrayList<Integer> levelOrder(Node node) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {

            Node top = q.poll();
            list.add(top.data);

            if(top.left != null) {
                q.add(top.left);
            }

            if(top.right != null) {
                q.add(top.right);
            }
        }
        return list;
    }
}
