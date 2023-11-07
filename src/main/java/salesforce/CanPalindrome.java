package salesforce;

import java.util.HashMap;
import java.util.Map;

public class CanPalindrome {
    
    private static boolean canFormPalindrome(String s) {
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] arr = s.toCharArray();
        for(Character c : arr) {
            int frequency = 0;
            if(frequencyMap.containsKey(c)) {
                frequency = frequencyMap.get(c);
            }
            frequency+=1;
            frequencyMap.put(c, frequency);
        }

        int oddCount = 0;

        for(Character key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if(freq%2 == 1) {
                oddCount++;
            }
        }

        return oddCount<=1;
    }

    public static void main(String args[])
    {
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
