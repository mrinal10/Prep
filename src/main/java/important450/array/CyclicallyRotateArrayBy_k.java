package important450.array;

public class CyclicallyRotateArrayBy_k {

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5,6,7,8};
        int k = 3;
        while(k-->0)
            rotateByOne(ar);

        printArray(ar);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void rotateByOne(int[] ar) {
        int temp = ar[ar.length - 1];
        for (int i = ar.length - 1; i>0; i--) {
            ar[i] = ar[i-1];
        }
        ar[0] = temp;
    }
}
