package important450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSome {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || nums[i]!=nums[i-1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        arr.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while (low<high && nums[low] == nums[low+1]) {
                            low++;
                        }
                        while (low<high && nums[high] == nums[high-1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
       int[] nums = {-1,0,1,2,-1,-4};

       ThreeSome ts = new ThreeSome();
       ts.threeSum(nums);
    }
}
