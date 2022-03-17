package important450.array;

import java.util.Arrays;

//Algo
/*1. Sort the given array.
2. Set the diff to the difference between the least element of the array and
    the first element of an array.
3. Set minimum to the first element of array + k and maximum to last element - k of the array.
4. Traverse the array from i=1 to i<n-1(one less than the length of the array).
  1. Set difference to arr[i]-k.
  2. Set sum to arr[i]+k.
  3. Check if the difference is greater than equal to minimum or sum is less than
    or equal to maximum.
    1. If true, then continue and skip this traversal.
  4. Check if maximum-difference is less than or equal to sum-minimum.
    1. If true, then update minimum to difference.
  5. Else set the maximum to sum.
5. Return the minimum between the diff and maximum-minimum.
* */
public class Minimize_the_heights {
    int getMinDiff(int[] arr, int n, int k) {
        int length = arr.length;
        Arrays.sort(arr);

        int indx = getFlipIndex(arr, k);
        if(indx != -1) {

            for (int i = 0; i <= indx; i++) {
                arr[i] += k;
            }
            for (int i = indx + 1; i < length; i++) {
                arr[i] -= k;
            }
            Arrays.sort(arr);
        }
        return (arr[length-1] - arr[0]);
    }

    private int getFlipIndex(int[] arr, int k) {
        int length = arr.length;
        for(int i=0; i<length-1; i++) {
            if( (arr[i+1] - arr[i]) < 2*k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ar = {1,5,8,10};
        int k = 2;

        Minimize_the_heights mHts = new Minimize_the_heights();
        System.out.println( mHts.getMinDiff(ar, ar.length, k) );
    }
}
