package amazon;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0, nums.length - 1);
        return ans;
    }

    private void helper(int[] nums, int l ,int r) {
        if(l==r) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++) {
                temp.add(nums[i]);
            }
            ans.add(temp);
        }

        for(int i=l; i<=r; i++) {
            swap(nums, l, i);
            helper(nums, l+1, r);
            swap(nums, l, i);
        }
    }

    private void swap(int[] nums, int to, int from) {

        int t = nums[to];
        nums[to] = nums[from];
        nums[from] = t;
    }
}
