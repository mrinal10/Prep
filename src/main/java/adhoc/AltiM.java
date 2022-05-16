package adhoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the arrival and departure times of all trains that reach a railway station,
 *  the task is to find the minimum number of platforms required for the railway station
 *  so that no train waits.
 * We are given two arrays that represent the arrival and departure times of trains that
 *  stop.
 * int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
 * int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
 * int n = 6;
 */


public class AltiM {

    private static int getMinPlatform(int[] arr, int[] dep) {

        Arrays.sort(dep);

        int maxPlatformReq = 0;
        if(arr.length > 0) {
            maxPlatformReq = 1;
        }

        int i = 0;
        int j = 0;
        int curTrainCount = 1;
        while(i < arr.length-1) {

            if(arr[i+1] < dep[j]) {
                curTrainCount += 1;
                i++;
            } else{
                curTrainCount -= 1;
                j++;
            }
            maxPlatformReq = Math.max(maxPlatformReq, curTrainCount);
        }

        return maxPlatformReq;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(getMinPlatform(arr, dep));
    }
}
