package dsalgo.leetcode;

/**
 * Initialize the lengths array to the number of possible centers.
	Set the current center to the first center.
	Loop while the current center is valid:
	
	(a) Expand to the left and right simultaneously until we find the largest Palindrome around this center.
	
	(b) Fill in the appropriate entry in the longest palindrome lengths array.
	
	(c) Iterate through the longest palindrome lengths array backwards and fill in the corresponding values to 
		the right of the entry for the current center until an unknown value (as described above) is encountered.
	
	(d) set the new center to the index of this unknown value.
	
	Return the longest substring. 

 * @author Mrinal
 *
 */

public class Leetcode5 {
	
	public String longestPalindrome(String s) {
		
		char[] arr = s.toCharArray();
		int longestPalindromeLength = 0;
		String longestPalindromicSubstring = "";
		int length = s.length();
		for(int i=0; i<arr.length; i++) {
			
			//for even
			int x = i;
			int y = i + 1;
			int palindrome = 0;
			while(x >= 0 && y < length && arr[x]==arr[y]) {
				x--;
				y++;
				palindrome += 2;
			}
			
			longestPalindromeLength = Math.max(longestPalindromeLength, palindrome);
			if(palindrome == longestPalindromeLength) {
				
				longestPalindromicSubstring = s.substring(x+1, y);
			}
			
			//for even
			x = i - 1;
			y = i + 1;
			palindrome = 1;
			while(x >= 0 && y < length && arr[x]==arr[y]) {
				x--;
				y++;
				palindrome += 2;
			}
			
			longestPalindromeLength = Math.max(longestPalindromeLength, palindrome);
			if(palindrome == longestPalindromeLength) {
				
				longestPalindromicSubstring = s.substring(x+1, y);
			}
		}
		
		return longestPalindromicSubstring;
	}
	
	public static void main(String[] args) {
		
		Leetcode5 leetcode5 = new Leetcode5();
		System.out.println(leetcode5.longestPalindrome("babad"));
	}

}
