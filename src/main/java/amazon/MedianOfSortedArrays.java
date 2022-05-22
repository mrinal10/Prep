package amazon;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int mid  = (l1 + l2 ) /2;
        if(mid%2!=0) {
            return (double) getIndexValue(mid, nums1, nums2);
        }
        return getIndexValue(mid-1, mid, nums1, nums2);
    }

    private static double getIndexValue(int index1, int index2, int[] arr1, int[] arr2) {
        return (double) (getIndexValue(index1, arr1, arr2) + getIndexValue(index2, arr1, arr2)) / 2;
    }

    private static double getIndexValue(int index, int[] arr1, int[] arr2) {

        int i = 0;
        int i1 = 0;
        int i2 = 0;

        while (i1 < arr1.length && i2 < arr2.length) {

            if(arr1[i1] < arr2[i2]) {
                if(i==index) {
                    return arr1[i1];
                }
                i1++;
            } else {
                if(i==index) {
                    return arr2[i2];
                }
                i2++;
            }
            i++;
        }

        while(i1 < arr1.length) {
            if(i==index) {
                return arr1[i1];
            }
            i1++;
            i++;
        }

        while(i2 < arr2.length) {
            if(i==index) {
                return arr2[i2];
            }
            i2++;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {};
        int[] a2 = {1};

        System.out.println(MedianOfSortedArrays.findMedianSortedArrays(a1, a2));
    }
}
