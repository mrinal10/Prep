package important450.array;

public class KadanesAlgo {

    static int maxSubArraySum(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int j : array) {
            max_ending_here += j;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(a));
    }
}