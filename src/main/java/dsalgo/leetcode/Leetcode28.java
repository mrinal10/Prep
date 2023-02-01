package dsalgo.leetcode;

/**
 * 
 * @author Mrinal
 *
 */

public class Leetcode28 {
	
	public int strStr(String haystack, String needle) {

        int startStringIndex = -1;
        
		if(needle.length() > haystack.length()) {
			return startStringIndex;
		}
        int needleLength = needle.length();
       
        for(int i = 0; i <= haystack.length() - needleLength; i++) {
        	String startString = haystack.substring(i, needleLength);
        	
        	if(startString.equals(needle)) {
        		startStringIndex = i; 
        	}
        }
        return startStringIndex;
    }
	
	public static void main(String[] args) {
		Leetcode28 leetcode28 = new Leetcode28();
		
		String hayStack = "l";
		String needle = "l";
		
		System.out.println(leetcode28.strStr(hayStack, needle));
	}

}
