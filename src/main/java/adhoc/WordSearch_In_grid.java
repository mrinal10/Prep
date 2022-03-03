package adhoc;

import java.util.ArrayList;
import java.util.List;

class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class WordSearch_In_grid {
    public int[][] searchWord(char[][] grid, String word) {

        int row = grid.length;
        int col = grid[0].length;
        List<Pair> words = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean found = dfs(grid, word, i, j, 0);
                if(found) {
                    Pair pair = new Pair(i, j);
                    words.add(pair);
                }
            }
        }

        int[][] ans = new int[words.size()][2];
        for (int i = 0; i <words.size(); i++) {
            ans[i][0] = words.get(i).row;
            ans[i][1] = words.get(i).col;
        }
        return ans;
    }

    private boolean dfs(char[][] grid, String word, int row, int col, int index) {
        int r = grid.length;
        int c = grid[0].length;

        if(row < 0 || col < 0
                || row >= r || col >= c) {

            return false;
        }

        if(grid[row][col] == word.charAt(index)) {
            char temp = grid[row][col];
            grid[row][col] = '#';
            if(index==word.length() - 1) {
                return true;
            } else if(dfs(grid, word, row-1, col, index+1) ||
                      dfs(grid, word,row+1, col, index+1)  ||
                      dfs(grid, word, row, col+1,index+1) ||
                      dfs(grid, word, row, col-1,index+1) ||
                      dfs(grid, word, row-1, col-1, index+1) ||
                      dfs(grid, word,row+1, col+1, index+1)  ||
                      dfs(grid, word, row-1, col+1,index+1) ||
                      dfs(grid, word, row+1, col-1,index+1)) {
                return true;
            }
            grid[row][col] = temp;
        }
        return false;
    }
}
