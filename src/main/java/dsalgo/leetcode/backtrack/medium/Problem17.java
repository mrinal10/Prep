package dsalgo.leetcode.backtrack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem17 {
    List<String> result;
    private Map<Character, String> getLetterMap() {
        return Map.of('2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList();

        char[] ch = digits.toCharArray();
        Map<Character, String> charMap = getLetterMap();
        rec(digits, 0, getLetterMap(), "");
        return result;
    }

    private void rec(String digits, int curIndex, Map<Character,
            String> mapOfLetter, String value) {

        if(curIndex == digits.length()) {
            if(!value.isEmpty() && !value.isBlank()) {
                result.add(value);
            }
            return;
        }

        char indexChar = digits.charAt(curIndex);
        String mappedString = mapOfLetter.get(indexChar);
        for(int i=0; i < mappedString.length(); i++) {
            value = value + mappedString.charAt(i);
            rec(digits, curIndex+1, mapOfLetter, value);
            value = value.substring(0, value.length()-1);
        }
    }

    public static void main(String[] args) {
        String s = "1";
        Problem17 p17 = new Problem17();
        List<String> result = p17.letterCombinations(s);

        for(String s1 : result) {
            System.out.println(s1);
        }
    }
}
