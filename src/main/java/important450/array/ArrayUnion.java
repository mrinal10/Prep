package important450.array;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayUnion {
    public static int doUnion(int a[], int n, int b[], int m) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<a.length; i++) {
           set.add(a[i]);
        }

        for(int i=0; i<b.length; i++) {
            set.add(b[i]);
        }
        return set.size();
    }
}
