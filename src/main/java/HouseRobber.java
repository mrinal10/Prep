public class HouseRobber {
    

    public int rob(int[] nums) {
        
        return Math.max(robHelper(nums, 0, 0, true), robHelper(nums, 1, 0, false));
    }

    public int robHelper(int[] nums, int index , int amountTillNow, boolean isFirstConsidered) {

        if(isFirstConsidered && index == nums.length-1) {
            return Integer.MIN_VALUE;
        }
        if(index >= nums.length) {
            return 0;
        }

        return amountTillNow + Math.max(nums[index] + 
                                robHelper(nums, index + 2, amountTillNow + nums[index], isFirstConsidered),
                                robHelper(nums, index + 1, amountTillNow, isFirstConsidered)
                               );
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        HouseRobber hr = new HouseRobber();
        System.out.print(hr.rob(arr));
    }
}
