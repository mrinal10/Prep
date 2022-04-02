package adhoc;

//https://www.geeksforgeeks.org/sort-binary-array-using-one-traversal/

public class SortBinaryArray {

    static void sortBinaryArray(int a[], int n) {

        int s = 0;
        int e = a.length - 1;

        while (s < e) {
            int start = a[s];
            int end = a[e];

            if (start==1 && end==0) {
                a[s] = 0;
                a[e] = 1;
                s++;
                e--;
            } else if(start==0 && end==0) {
                s++;
            } else if(start==1 && end==1) {
                e--;
            } else {
                s++;
                e--;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };

        int n = a.length;

        sortBinaryArray(a, n);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
