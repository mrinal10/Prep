package dsalgo.leetcode.todo.jpmorgan;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class BSTIterator {

    List<Integer> listInt;
    int curVal ;
    public BSTIterator(TreeNode root) {
        listInt = new ArrayList<Integer>();
        curVal = Integer.MIN_VALUE;
        init(root);
    }

    private void init(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left!=null) {
            init(root.left);
        }

        listInt.add(root.val);

        if(root.right!=null) {
            init(root.right);
        }
    }

    public int next() {
        for(int i=0; i<listInt.size(); i++) {
            if (curVal<listInt.get(i)) {
                curVal = listInt.get(i);
                return curVal;
            }
        }
        return -1;
    }

    public boolean hasNext() {
        for(int i=0; i<listInt.size(); i++) {
            if (curVal<listInt.get(i)) {
                return true;
            }
        }
        return false;
    }
}
