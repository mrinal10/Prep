package important450.array;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == k)
                maxLen = i+1;
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum - k) && maxLen < (i - map.get(sum - k))) {
                maxLen = i - map.get(sum - k);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] ar = {1,-1,5,-2,3};
        int k = 3;
        MaxSubArraySumEqualsK maxSumK = new MaxSubArraySumEqualsK();

        System.out.println(maxSumK.maxSubArrayLen(ar, k));
    }
}
