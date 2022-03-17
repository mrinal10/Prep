package adhoc;
//given a sorted array where each element is there exactly twice, only one element with single occurrence.
//e.g. [1,1,2,3,3,4,4,8,8] . output-> 2

public class Single_element_SortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while(l<h) {
            int mid = l + (h - l)/2;
            boolean halvesAreEven = ((h-mid)%2 == 0);

            if (nums[mid] == nums[mid - 1]) {
                if(halvesAreEven) {
                    h = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if(halvesAreEven) {
                    l = mid+2;
                } else {
                    h=mid-1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }
}
