package dsalgo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode136 {
	//find the number which is only once;
	public int singleNumber(int[] nums) {
        int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			set.add(nums[i]);
			sum += nums[i];
		}
		
		int doubleSum = 0;
		for(Integer i : set) {
			doubleSum += (i * 2);
		}
		
		return doubleSum - sum;
    }

}
