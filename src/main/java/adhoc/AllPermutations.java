package adhoc;

import java.util.HashSet;
import java.util.Set;

public class AllPermutations {

    private Set<String> set;

    void gen(String str) {
        set = new HashSet<>();
        generatePermutations(str, 0, str.length() - 1);
        set.forEach(System.out::println);
    }

    void generatePermutations(String str, int s, int e) {
        if(s == e) {
            set.add(str);
        } else {
            for (int l = s; l <= e; l++) {
                str = swap(str, s, l);
                generatePermutations(str, l + 1, e);
                str = swap(str, s, l);
            }
        }
    }

    String swap(String str, int l, int e) {
        char[] a = str.toCharArray();
        char temp = a[l];
        a[l] = a[e];
        a[e] = temp;
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        String s = "aabb";
        AllPermutations apm = new AllPermutations();
        apm.gen(s);

    }

}
