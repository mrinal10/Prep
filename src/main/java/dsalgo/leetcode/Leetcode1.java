package dsalgo.leetcode;

public class Leetcode1 {

	public int[] twoSum(int[] nums, int target) {
		
		int[] ans = new int[2];
		
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int trgt = nums[i] + nums[j];
				if(trgt==target) {
					ans[0] = i;
					ans[1] = j;
					break;
				}
			}
		}
		return ans;
    }
}
