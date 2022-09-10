package dsalgo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//subsets II
public class Leetcode90 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		subset(nums, 0, nums.length, new ArrayList<>(), result);
		return result;
	}

	public void subset(int[] nums, int start, int size, 
			List<Integer> current, List<List<Integer>> total) {

		total.add(new ArrayList<>(current));
		for (int i = start; i < size; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				current.add(nums[i]);
				subset(nums, i + 1, size, current, total);
				current.remove(current.get(current.size() - 1));
			}
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };

		Leetcode90 leetcode = new Leetcode90();
		List<List<Integer>> ans = leetcode.subsetsWithDup(nums);
		for (List<Integer> list : ans) {
			for (Integer i : list) {

				System.out.print(i + " ");
			}

			System.out.println();
		}
	}

}
