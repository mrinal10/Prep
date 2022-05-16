package important450.array;

import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeating {

    int[] findTwoElement(int arr[], int n) {
        Set<Integer> missing = new HashSet();

        int repeated = -1;
        int miss = -1;

        for(int i=0; i<n; i++) {
            int v = arr[i];
            if(missing.contains(v)) {
                repeated = v;
            }
            missing.add(v);
        }

        for(int i=0; i<n; i++) {
            if(!missing.contains(i+1)) {
                miss = i+1;
                break;
            }
        }

        int[] ans = new int[2];
        ans[0] = miss;
        ans[1] = repeated;

        return ans;
    }
}
