package lupin;
/*
Input: words = ["bella","label","roller"]
Output: {"e","l","l"}

Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 */

import java.util.ArrayList;
import java.util.List;

public class Lupin {

    List<Character> getRepeatedChars(List<String> stringList) {

        int inputCount = stringList.size();
        int[][] grid = new int[inputCount][26];
        for(int j=0; j< stringList.size(); j++) {
            String str = stringList.get(j);
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                int index = ((int)c) - 97;
                grid[j][index] += 1;
            }
        }

        List<Character> ans = new ArrayList<>();

        for(int i=0; i<grid[0].length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<grid.length; j++) {
                if(min > grid[j][i]) {
                    min = grid[j][i];
                }
            }
            char c = (char)(97+i);
            while(min!=0) {
                ans.add(c);
                min--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("bella");
        words.add("label");
        words.add("roler");

//        words.add("cool");
//        words.add("lock");
//        words.add("cook");

        Lupin l1 = new Lupin();
        List<Character> ans = l1.getRepeatedChars(words);
        for (Character c : ans) {
            System.out.println(c);
        }
    }
}
