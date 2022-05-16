package important450.array;

public class MoveNegativesToLeft {

    static void rearrange(int[] arr, int n) {
        int first = 0;
        int last = n - 1;

        while(first < last) {
            if(arr[first] > 0 && arr[last] < 0) {
                int temp = arr[last];
                arr[last] = arr[first];
                arr[first] = temp;
                last--;
                first++;
            } else if(arr[first] < 0 && arr[last] < 0 ) {
                first++;
            } else {
                last--;
            }

        }
    }

    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;

        rearrange(arr, n);
        printArray(arr, n);
    }
}