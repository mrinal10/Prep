package important450.array;

import java.util.Arrays;
import java.util.List;

//Find the "Kth" max and min element of an array
public class Find_kth_max_min {

    static int getKthMin(Integer[] ar, int k) {
        Arrays.sort(ar);
        printArray(ar);
        return ar[k-1];
    }

    static int getKthMax(Integer[] ar, int k) {
        return ar[ar.length-k];
    }

    static void printArray(Integer[] ar) {
        List<Integer> ll = Arrays.asList(ar);
        ll.forEach(el-> System.out.print(el+" "));
    }

    public static void main(String[] args) {
        Integer[] ar = {1,34,56,-1,2809,-9,7};
        System.out.println(getKthMin(ar, 5) + " " +getKthMax(ar,5));
    }
}
