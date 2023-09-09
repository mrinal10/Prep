import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithourNonRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int length = 0;
        int startIndex = 0;

        for(int curIndex=0; curIndex<s.length(); curIndex++) {
            char c = s.charAt(curIndex);
            if(map.containsKey(c)) {
                int index = map.get(c);
                if(index < startIndex) {
                    startIndex = Math.max(startIndex, index);
                } else {
                    startIndex = index + 1;
                }
            }
            map.put(c, curIndex);
            length = Math.max(length, curIndex - startIndex + 1);
            
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";//"a";"fdfq";// 
        LongestSubstringWithourNonRepeatingCharacter l3 = new LongestSubstringWithourNonRepeatingCharacter();
        System.out.println(l3.lengthOfLongestSubstring(s));
    }
    
}
