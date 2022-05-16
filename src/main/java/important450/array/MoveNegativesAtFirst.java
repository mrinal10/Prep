package important450.array;

public class MoveNegativesAtFirst {

    static void rearrange(int[] arr) {
        int length = arr.length;
        int j = 0;

        for(int i=0; i<length; i++) {
            if(arr[i] < 0) {
                if(i != j) {
                    swap(arr, i, j);
                }
                j++;
            }
        }
    }

    static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        rearrange(arr);
        printArray(arr);
    }
}
