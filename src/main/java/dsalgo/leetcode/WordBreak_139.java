package dsalgo.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Mrinal
 *
 */

public class WordBreak_139 {
	
	 public boolean wordBreak(String s, List<String> wordDict) {
	     
		 Set<String> dictionary = new HashSet<String>(wordDict);
		 boolean[] dp = new boolean[s.length() + 1];
		 
		 dp[0] = true;
		 for(int i = 1; i <= s.length(); i++) {
			 
			 for(int j = 0; j < i; j++) {
			
				 if(dp[j] && dictionary.contains(s.substring(j, i))) {
					 dp[i] = true;
					 break;
				 }
			 }
		 }
		 
		 return dp[s.length()];
	 }
}