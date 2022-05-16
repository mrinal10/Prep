package problemset.vmware.set1;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len];

        for(int i=1; i<len; i++) {
            for(int j=0; j<i; j++) {

                if(nums[j] < nums[i] & lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<len; i++) {
            max = Math.max(max, lis[i]);
        }

        return max+1;
    }
}
