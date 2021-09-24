package gfg.ds.algo;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class CustomCOmparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String XY = o1+o2;
        String YX = o2+o1;

        return XY.compareTo(YX)>0 ? -1 : 1;
    }
}

public class ArrangeNumbers_form_biggest_number {

    public static void main(String[] args) {
        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");

        Collections.sort(arr, new CustomCOmparator());
    }
}
