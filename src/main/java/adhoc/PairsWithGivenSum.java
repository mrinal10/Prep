package adhoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PairsWithGivenSum {
    int getPairsCount(int[] arr, int n, int k) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int c = arr[i];
            if(map.containsKey(c)) {
                int v = map.get(c);
                v += 1;
                map.put(c, v);
            } else {
                map.put(c, 1);
            }
        }

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet) {
            int frequency = map.get(key);
            int diff = k - key;
            if(map.containsKey(diff)) {
                int diffFrequency = map.get(diff);
                if(diff == key) {
                    count += ((frequency - 1) * diffFrequency);
                } else {
                    count += (diffFrequency * frequency);
                }
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        int[] ar = {1,5,5,7,-1};
        PairsWithGivenSum pSum = new PairsWithGivenSum();
        System.out.println(pSum.getPairsCount(ar, ar.length, 6));
    }
}
