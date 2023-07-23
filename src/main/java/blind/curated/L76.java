package blind.curated;

import java.util.HashMap;
import java.util.Map;
public class L76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            Character c=t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int left=0;
        int toBeMatched=map.size();
        int minSize=Integer.MAX_VALUE;
        int startIndex=0;
        for(int right=0; right<s.length(); right++){
            Character rChar = s.charAt(right);
            if(map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) == 0) {
                    toBeMatched--;
                }
            }
            while(left<=right && toBeMatched==0){
                if(minSize > right-left+1){
                    minSize = right-left+1;
                    startIndex = left;
                }
                Character leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar)>0) {
                        toBeMatched++;
                    }
                }
                left++;
            }
        }
        return minSize==Integer.MAX_VALUE ? ""
                : s.substring(startIndex, startIndex+minSize);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        L76 l76 = new L76();
        System.out.print(l76.minWindow(s, t));
    }
}
