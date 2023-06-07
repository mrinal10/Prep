package sixty.days.dsa.day8;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;

        int n1 = p.val;
        int n2 = q.val;

        if(root.val<n1 && root.val<n2) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > n1 && root.val > n2) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
