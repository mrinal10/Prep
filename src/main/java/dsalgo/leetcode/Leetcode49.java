package dsalgo.leetcode;

import java.util.*;

/**
 * 
 * @author Mrinal
 *
 */

public class Leetcode49 {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs) {
        	String sortedString = getSortedString(str);
        	List<String> arr = new ArrayList<String>();
        	if(map.containsKey(sortedString)) {
        		arr = map.get(sortedString);
        	}
        	arr.add(str);
        	map.put(sortedString, arr);
        }
    	for(String key : map.keySet()) {
    		ans.add(map.get(key));
    	}
        
        return ans;
    }

	private String getSortedString(String s) {
		
		char[] carr = s.toCharArray();
		
		for(int i = 0; i < carr.length - 1; i++) {
			for(int j = 0; j < carr.length - i - 1; j++) {
				
				if(carr[j] > carr[j+1]) {
					char temp = carr[j];
					carr[j] = carr[j+1];
					carr[j+1] = temp;
				}
			}
		}
		return String.valueOf(carr);
	}
	
	public static void main(String[] args) {
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		
		Leetcode49 leetcode49 = new Leetcode49();
		leetcode49.groupAnagrams(arr);
	}
}
