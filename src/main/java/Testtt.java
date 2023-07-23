public class Testtt {

    //,10,11, 14, 15 , 21,41,51, 61, 71
    // 71,10,11,21,41,51, 61
    //21,41,51, 61, 71,10,11,
    // 12 13 1 2 3 4 5 6 7 8 9 10 11
    public static void main(String[] args) {

        int[] arr = {3,2};//{21,41,51, 61, 71,10,11};//{71,10,11,21,41,51, 61};//{};//{12, 13, 1, 2 ,3 ,4, 5, 6, 7, 8, 9, 10, 11};//
        Testtt t = new Testtt();
        System.out.print(t.findMin(arr));
    }



    public int findMin(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        int mid;
        while(start < end) {
            mid = (start + end)/2;

            if(mid!=0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(mid+1 < nums.length
                    && nums[mid+1]<nums[mid]) {
               return nums[mid+1];
            }


            if(nums[start] < nums[mid]) { //left sorted
                if(nums[end] < nums[start]) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            } else { // right sorted
                end = mid;
            }
        }
        return nums[start];
    }


}
