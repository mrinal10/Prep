package important450.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    static int majorityElement(int a[], int size) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a) {
            int freq = 0;
            if(map.containsKey(i)) {
                freq = map.get(i);
            }
            freq++;
            map.put(i, freq);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getValue();
            int key = entry.getKey();

            if(value > size/2) {
                return key;
            }
        }

        return -1;
    }
}
