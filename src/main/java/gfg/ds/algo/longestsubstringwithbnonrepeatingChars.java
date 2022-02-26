package gfg.ds.algo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class longestsubstringwithbnonrepeatingChars {
    public static void main(String []args) {
        String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        int length = longestUniqueSubStr(s);
        System.out.println("The length of the longest non-repeating character substring is " + length);
    }

    static int longestUniqueSubStr(String s) {

        String date1 = "2021-10-07 00:00";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        LocalDateTime d1 = LocalDateTime.parse(date1, df);

        System.out.println(d1.toString());
        return 0;
    }
}
