package sixty.days.dsa.day1;

import java.util.HashMap;
import java.util.Map;

public class TWOSUM {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> numMap = new HashMap();
        for(int i=0; i< nums.length; i++) {
            int complement = target - nums[i];
            if(numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        throw new IllegalStateException("No Data Found");
    }

    public static void main(String[] args) {
        TWOSUM tSum = new TWOSUM();
        int[] abc = {1,2,3,4,5};
        tSum.twoSum(abc, 5);
    }
}
