package salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beautiful String
A string is beautiful if no two adjacent characters are
• either the same, for example 'aa'
• adjacent in the alphabet, for example 'ef'.

The following operations can be performed on a string, s.
• Choose any index i (0 ≤ i < |s|) and change s[i] to any lowercase English letter.

Find the minimum number of operations required to make the string beautiful.

Example -
s = "abdde"
String s is not beautiful because:
• 'dd' violates constraint 1, no two adjacent characters are the same.
• 'ab' and 'de' violate constraint 2, no two adjacent characters are adjacent in the alphabet.

The string can be converted into a beautiful string after 2 operations. One solution is below.
• Choose i=1 and change s[i] to 'z'. s becomes "azdde".
• Choose i=3 and change s[i] to 'k'. s becomes "azdke" which is beautiful.

Note: There are many other solutions such as "ardze", "axdke", etc.
It can be shown that 2 is the minimum number of operations required so return 2.
 */

public class BeautifulString {
    
    public static int makeBeautifulOpCount(String s) {
        
        char[]  carr = s.toCharArray();
        int ans = 0;

        List<Integer> set = new ArrayList<Integer>();
        
        for(int i=0; i<carr.length-1; i++) {
            
            char cur = carr[i];
            char next = carr[i+1];

            if((cur == next) || (Math.abs((int)cur - (int)next) == 1) ) {
                set.add(i);
            }
        }

        if(set.size()!=0) {
            ans = 1;
            int cur = set.get(0);
            for(int i=1; i<set.size(); i++) {
                if(set.get(i) - cur != 1) {
                    ans++;
                }
                cur = set.get(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abdde";
        System.out.println(makeBeautifulOpCount(str));
    }
}
