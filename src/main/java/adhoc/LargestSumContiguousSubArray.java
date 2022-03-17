package adhoc;

public class LargestSumContiguousSubArray {

    static int maxSubArraySum(int[] a) {

        int size = a.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for(int i=0; i<size; i++) {

            maxEndingHere = maxEndingHere + a[i];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }
}
