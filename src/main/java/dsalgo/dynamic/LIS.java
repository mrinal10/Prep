package dsalgo.dynamic;

public class LIS {

    private static int getLengthOfLIS(int[] arr) {
        int ans = 1;

        int[] DP = new int[arr.length];
        for (int i=0; i<arr.length; i++)
            DP[i] = 1;

        for(int i = 1; i<arr.length; i++) {
            if(arr[i]-arr[i-1] > 0) {
                DP[i] = DP[i-1] + 1;
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(ans<DP[i]) {
                ans = DP[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {50, 3,10,21,20};
        System.out.println(getLengthOfLIS(array));
    }
}
