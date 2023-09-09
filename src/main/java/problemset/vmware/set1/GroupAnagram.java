package problemset.vmware.set1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        for(String str : strs) {
            String convertedString = getSortedString(str);
            List<String> list = new ArrayList<>();
            if(groups.containsKey(convertedString)) {
                list = groups.get(convertedString);
            }
            list.add(str);

            groups.put(convertedString, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : groups.keySet()) {

            ans.add(groups.get(key));
        }

        return ans;
    }

    public String getSortedString(String s) {
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length-1; i++) {
            for (int j = 0; j < c.length-i-1; j++) {

                if(c[j] > c[j+1]) {
                    char temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagram groupAnagram = new GroupAnagram();
        groupAnagram.groupAnagrams(strs);
    }
}
