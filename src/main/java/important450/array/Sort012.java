package important450.array;

public class Sort012 {
    public static void sort012(int[] a, int n) {

        int smallerIndex = 0;
        int largerIndex = n-1;
        int midIndex = 0;
        int temp = 0;

        while (midIndex <= largerIndex) {
            switch (a[midIndex]) {
                case 0:
                    temp = a[smallerIndex];
                    a[smallerIndex] = a[midIndex];
                    a[midIndex] = temp;
                    smallerIndex++;
                    midIndex++;
                    break;
                case 1:
                    midIndex++;
                    break;
                case 2:
                    temp = a[midIndex];
                    a[midIndex] = a[largerIndex];
                    a[largerIndex] = temp;
                    largerIndex--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {1,2,0,2,1};
        sort012(ar, ar.length);
        for(int i=0; i<ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
