package important450.tree.view;

import java.util.*;
import important450.tree.Node;

public class RightView {

    class QNode {
        Node value;
        int level;
        QNode(Node v, int l) {
            value = v;
            level = l;
        }
    }

    LinkedHashMap<Integer, Integer> map;
    ArrayList<Integer> rightView(Node root) {

        map = new LinkedHashMap<>();
        Queue<QNode> q = new LinkedList();
        QNode qnode = new QNode(root, 0);
        q.add(qnode);

        while (!q.isEmpty()) {

            QNode node = q.poll();
            Node curNode = node.value;
            int level = node.level;

            map.put(level, curNode.data);
            if(curNode.left!=null) {
                QNode left = new QNode(curNode.left, level+1);
                q.add(left);
            }
            if(curNode.right!=null) {
                QNode right = new QNode(curNode.right, level+1);
                q.add(right);
            }
        }

        ArrayList<Integer> rightView = new ArrayList();

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            rightView.add(map.get(key));
        }
        return rightView;
    }
}
