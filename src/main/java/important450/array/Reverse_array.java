package important450.array;

import java.util.Arrays;
import java.util.List;

//Reverse the array
public class Reverse_array {
    // Driver code
    private static void printArray(Integer[] ar) {
        List<Integer> ll = Arrays.asList(ar);
        ll.forEach(el-> System.out.print(el+" "));
    }

    private static void reverseArray(Integer[] ar, int start, int end) {
        if(start>=end)
            return;

        int temp = ar[start];
        ar[start] = ar[end];
        ar[end] = temp;

        reverseArray(ar, start+1, end-1);
    }

    public static void main(String args[]) {

        Integer arr[] = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr);
        reverseArray(arr, 0, arr.length-1);
        System.out.print("Reversed array is \n");
        printArray(arr);

    }
}
