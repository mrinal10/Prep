import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1110 {
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int i=0; i<to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        List<TreeNode> ans = helper(root);
        if(!set.contains(root.val)) {
            ans.add(root);
        }
        return ans;
    }

    private List<TreeNode> helper(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        ans.addAll(helper(root.left));
        ans.addAll(helper(root.right));
        if(set.contains(root.val)) {
            if(root.left!=null)
                ans.add(root.left);
            if(root.right!=null)
                ans.add(root.right);
        }
        return ans;
    }
}