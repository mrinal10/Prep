package sixty.days.dsa.additional;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];

        for(int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {

                if(nums[j] < nums[i] &&  arr[i]<arr[j]+1) {
                    arr[i] = arr[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i=0; i<arr.length; i++) {
            if(max<arr[i]) {
                max = arr[i];
            }
        }
        return max + 1;
    }
}


