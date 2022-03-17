package tree.view;

import java.util.*;
import tree.Node;

public class TopView {

    class QNode {
        Node value;
        int level;
        QNode(Node v, int l) {
            value = v;
            level = l;
        }
    }

    TreeMap<Integer, Integer> map;
    ArrayList<Integer> topView(Node root) {

        map = new TreeMap<>();
        Queue<QNode> q = new LinkedList<>();
        QNode qnode = new QNode(root, 0);
        q.add(qnode);

        while (!q.isEmpty()) {

            QNode node = q.poll();
            Node curNode = node.value;
            int level = node.level;

            if(!map.containsKey(level))
                map.put(level, curNode.data);

            if(curNode.left!=null) {
                QNode left = new QNode(curNode.left, level-1);
                q.add(left);
            }
            if(curNode.right!=null) {
                QNode right = new QNode(curNode.right, level+1);
                q.add(right);
            }
        }

        ArrayList<Integer> topView = new ArrayList<>();

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            topView.add(map.get(key));
        }
        return topView;
    }
}
