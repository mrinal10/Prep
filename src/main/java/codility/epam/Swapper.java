package codility.epam;

/*

Given a string S consisting of N letters a and b. In one move you can replace one letter by the other (a by b or b by a).
Write a function solution that given such a string S, returns the minimum number of moves required to obtain a string containing no instances of three identical consecutive letters.
#Example 1:
Input: "baaaaa"
Output: 1
Explanation: The string without three identical consecutive letters which can be obtained is one move is "baabaa".

Example 2:
Input: "baaabbaabbba"
Output: 2
Explanation: There are four valid strings obtainable in two moves, for example "bbaabbaabbaa".

Example 3:
Input: "baabab"
Ouput: 0

Assumptions:
N is an integer within the range [0, ..200,000];
string S consists of only characteres a and b*
* */
public class Swapper {

    public int solution(String s) {

        char[] arr = s.toCharArray();

        int count = 0;
        int result = 0;
        for(int i=1; i<s.length(); i++){
            char c = arr[i];
            if(c == arr[i-1]) {
                count++;
            }

            if(count==3) {
                count = 0;
                if(c == 'a') {
                    arr[i-1] = 'b';
                } else {
                    arr[i-1] = 'a';
                }
                result++;
            }
        }
        return result;
    }
}
