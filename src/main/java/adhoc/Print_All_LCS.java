package adhoc;

import java.util.*;

public class Print_All_LCS {
    // Function to return all LCS of substrings `X[0…m-1]`, `Y[0…n-1]`
    public static List<String> LCS(String X, String Y, int m, int n, int[][] lookup)
    {
        // if the end of either sequence is reached
        if (m == 0 || n == 0)
        {
            // create a list with one empty string and return
            return new ArrayList<>(Collections.nCopies(1, ""));
        }

        // if the last character of `X` and `Y` matches
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // ignore the last characters of `X` and `Y` and find all LCS of
            // substring `X[0…m-2]`, `Y[0…n-2]` and store it in a list
            List<String> lcs = LCS(X, Y, m - 1, n - 1, lookup);

            // append current character `X[m-1]` or `Y[n-1]`
            // to all LCS of substring `X[0…m-2]` and `Y[0…n-2]`
            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + (X.charAt(m - 1)));
            }

            return lcs;
        }

        // we reach here when the last character of `X` and `Y` don't match

        // if a top cell of the current cell has more value than the left cell,
        // then ignore the current character of string `X` and find all LCS of
        // substring `X[0…m-2]`, `Y[0…n-1]`
        if (lookup[m - 1][n] > lookup[m][n - 1]) {
            return LCS(X, Y, m - 1, n, lookup);
        }

        // if a left cell of the current cell has more value than the top cell,
        // then ignore the current character of string `Y` and find all LCS of
        // substring `X[0…m-1]`, `Y[0…n-2]`
        if (lookup[m][n - 1] > lookup[m - 1][n]) {
            return LCS(X, Y, m, n - 1, lookup);
        }

        // if the top cell has equal value to the left cell,
        // then consider both characters

        List<String> top = LCS(X, Y, m - 1, n, lookup);
        List<String> left = LCS(X, Y, m, n - 1, lookup);

        // merge two lists and return
        top.addAll(left);

        return top;
    }

    // Function to fill the lookup table by finding the length of LCS
    // of substring `X` and `Y`
    public static void LCSLength(String X, String Y, int[][] lookup)
    {
        // fill the lookup table in a bottom-up manner
        for (int i = 1; i <= X.length(); i++)
        {
            for (int j = 1; j <= Y.length(); j++)
            {
                // if current character of `X` and `Y` matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                }
                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
    }

    // Function to find all LCS of string `X[0…m-1]` and `Y[0…n-1]`
    public static Set<String> LCS(String X, String Y, int[][] lookup)
    {
        // fill lookup table
        LCSLength(X, Y, lookup);

        // find all the longest common subsequences
        List<String> lcs = LCS(X, Y, X.length(), Y.length(), lookup);

        // since a list can contain duplicates, "convert" it to a set and return
        return new HashSet<>(lcs);
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // lookup[i][j] stores the length of LCS of substring `X[0…i-1]` and `Y[0…j-1]`
        int[][] lookup = new int[X.length() + 1][Y.length() + 1];

        Set<String> lcs = LCS(X, Y, lookup);

        // print set elements
        System.out.println(lcs);
    }
}