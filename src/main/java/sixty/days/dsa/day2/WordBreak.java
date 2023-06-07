package sixty.days.dsa.day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i=1; i <= s.length(); i++) {
            for (int j=0; j<i; j++){
                if(res[j] && set.contains(s.substring(j,i))) {
                   res[i] = true;
                }
            }
        }

        return res[s.length()];
    }
}
