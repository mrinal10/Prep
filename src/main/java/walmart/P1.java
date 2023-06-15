package walmart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note: that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true

a

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


public boolean wordBreak(String s, List<String> wordDict) {

}
* */
public class P1 {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        String subString = "";
        for(int i=0; i<s.length(); i++) {
            subString = subString + s.charAt(i);
            if(set.contains(subString)){
                subString = "";
            }
        }
        return (subString.length()==0);
    }

    public static void main(String[] args) {
//        s = "applepenapple", wordDict = ["apple","pen"]
        String s = "catsandog";
//        String s = "applepenapple";
        List<String> wordDictionary = new ArrayList<>();
//        wordDictionary.add("apple");
//        wordDictionary.add("pen");
        wordDictionary.add("cats");
        wordDictionary.add("dog");
        wordDictionary.add("sand");
        wordDictionary.add("and");
        wordDictionary.add("cat");
        P1 p1 = new P1();
        System.out.println(p1.wordBreak(s, wordDictionary));
    }
}
