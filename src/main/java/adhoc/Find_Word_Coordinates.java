package adhoc;

import java.util.ArrayList;
import java.util.List;

public class Find_Word_Coordinates {

    private static void findWords(char[][] grid, String s) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j< grid[0].length; j++) {
                List<String> path = new ArrayList<String>();
                findWordsUtil(grid, s, 0, i, j, path);
            }
        }
    }

    private static void findWordsUtil(char[][] grid, String s, int index, int r, int c, List<String> path) {

        if (index == s.length()) {
            System.out.println(path);
            return;
        }

        if(isSafe(grid, r, c)) {
            return;
        }

        if(grid[r][c] == s.charAt(index))
            path.add("("+r+", "+c+") ");
        else
            return;

        findWordsUtil(grid, s, index+1, r, c + 1, path);
        findWordsUtil(grid, s, index+1, r + 1, c, path);
    }

    private static boolean isSafe(char[][] grid, int r, int c) {
        return (r<0 || r >= grid.length || c<0 || c >= grid[0].length);
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'d', 'r', 'd', 'o', 'r', 's'},
            {'o', 'b', 'i', 'g', 'n', 'c'},
            {'g', 'f', 'n', 'm', 't', 'a'},
            {'x', 's', 'i', 'a', 'n', 't'}};

        String[] words1 = { "cat", "dog", "dogma"};

        for(String word : words1) {
            findWords(grid, word);
        }

        /*
        findWords(grid, words)->
          [ [ (1, 5), (2, 5), (3, 5) ], # cat
            [ (0, 2), (0, 3), (1, 3), (2, 3), (3, 3)], # dogma
            [ (0, 0), (1, 0), (2, 0) ], # dog
          ]
        * */
    }
}
