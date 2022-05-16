package gfg.ds.algo;

import java.util.Arrays;

public class minimum_number_platforms_req {

    public static int findPlatform(int[] arr, int[] dep,
                                   int n) {
        int requiredPlatforms = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int arrivalIndex = 1;
        int departureIndex = 0;
        int maxPlatform = 1;

        while(arrivalIndex<n  && departureIndex<n) {

            if(arr[arrivalIndex] <= dep[departureIndex]) {
                maxPlatform ++;
                arrivalIndex++;
            } else {
                maxPlatform--;
                departureIndex++;
            }

            if(maxPlatform > requiredPlatforms) {
                requiredPlatforms = maxPlatform;
            }
        }
        return requiredPlatforms;
    }


    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }
}
