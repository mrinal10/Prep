package important450;

public class FoundInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) { // found
                return mid;
            } else if (nums[mid] >= nums[start]) { // left side is sorted
                if (target >= nums[start] && target < nums[mid])  //target is between start & mid
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[end]) //target is between end & mid
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
