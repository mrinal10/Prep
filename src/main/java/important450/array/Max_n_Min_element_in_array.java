package important450.array;

//Find the maximum and minimum element in an array
public class Max_n_Min_element_in_array {

    static void printMax_min(int[] ar) {
        int min = ar[0];
        int max = ar[0];

        for(int i=0; i<ar.length; i++) {
            if(ar[i] < min) {
                min = ar[i];
            }
            if(ar[i] > max) {
                max = ar[i];
            }
        }
        System.out.println(min+" "+max);
    }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, -1, 330, 3000};
        int arr_size = 6;
        printMax_min(arr);
    }
}
