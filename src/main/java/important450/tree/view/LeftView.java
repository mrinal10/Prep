package important450.tree.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.*;
import important450.tree.Node;

public class LeftView {

    LinkedHashMap<Integer, Integer> map;
    List<Integer> leftView(Node root) {

        map = new LinkedHashMap<>();
        leftViewUtil(root, 0);
        List<Integer> rightView = new ArrayList<Integer>();

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            rightView.add(map.get(key));
        }
        return rightView;
    }

    void leftViewUtil(Node root, int level) {
        if(root == null) {
            return;
        }

        if(!map.containsKey(level)) {
            map.put(level, root.data);
        }

        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }
}
