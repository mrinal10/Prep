import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

public class SubtreeOfANotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    
        boolean isEqual = false;
        
        if(root == null || subRoot == null) {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode treeNode = q.remove();
            if(treeNode.val == subRoot.val) {
                isEqual = isEqual || isEqual(treeNode, subRoot);
            }
            if(isEqual) {
                return isEqual;
            }

            if(treeNode.left != null)
                q.add(treeNode.left);
            if(treeNode.right != null)
                q.add(treeNode.right);
        }
        StringBuilder sb = new StringBuilder();
//        sb.replace();
//        Collections.binarySearch()
        return isEqual;
    }


    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) {
            return true;
        }
        if(root==null || subRoot==null || (root.val != subRoot.val)) {
            return false;
        }
        
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }
}