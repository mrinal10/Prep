package dsalgo.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    List<List<Integer>> problemList;

    public List<List<Integer>> permute(int[] nums) {
        problemList = new ArrayList<>();
        helper(nums, 0, nums.length-1);
        return problemList;
    }

    public void helper(int[] arr, int l, int r) {
       if(l == r) {
           List<Integer> temp = new ArrayList<>();
           for(int i=0; i<arr.length; i++) {
               temp.add(arr[i]);
           }
           problemList.add(temp);
       } else {
           for (int i = l; i <= r; i++) {
               swap(arr, l, i);
               helper(arr, l+1, r);
               swap(arr, l, i);
           }
       }


    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}