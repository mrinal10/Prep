package important450.array;

import java.util.Arrays;

public class SortWarray_012 {

    private static void sortArray(int[] ar) {
        int start = 0;
        int mid = 0;
        int end = ar.length - 1;

        while (mid <= end) {
            if(ar[mid] < 1) { // 0 - case
                swap(ar, start, mid);
                ++mid;
                ++start;
            } else if(ar[mid] == 2) {
                swap(ar, mid, end);
                --end;
            } else {
                ++mid;
            }
        }
    }

    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main (String[] args) {
        int[] A = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

        sortArray(A);
        System.out.println(Arrays.toString(A));
    }
}
