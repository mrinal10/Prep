package adhoc;

import java.util.List;

public class MinSwapstoSort {

    static int merge(int arr[], int temp[], int left, int mid, int right) {
        int inv_count = 0;
        int i = left;
        int j = mid;
        int k = left;

        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
            {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }

    static int _mergeSort(int arr[], int temp[],
            int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
            mid = (right + left)/2;
            inv_count = _mergeSort(arr, temp,
                    left, mid);

            inv_count += _mergeSort(arr, temp,
                    mid+1, right);

            inv_count += merge(arr, temp,
                    left, mid+1, right);
        }

        return inv_count;
    }

    public static int getMinMoves(List<Integer> plates) {
        int[] temp = new int[plates.size()];
        int[] arr = new int[plates.size()];
        for(int i=0; i<plates.size(); i++) {
            arr[i] = plates.get(i);
        }
        return _mergeSort(arr, temp, 0, plates.size() - 1);
    }
}
