package walmart;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */
public class P2 {

    public boolean exist(char[][] board, String word) {
        int rCount = board.length;
        int cCount = board[0].length;
        boolean[][] visited = new boolean[rCount][cCount];;
        for(int i=0; i<rCount; i++) {
            for(int j = 0; j<cCount; j++) {
                if(board[i][j] == word.charAt(0)) {
                    return helper(board, word, 0, visited, i, j);
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int index, boolean[][] visited, int row, int column) {
        if(isNotSafe(board, row, column)) {
            return false;
        }

        if(!visited[row][column] && board[row][column] == word.charAt(index)) {
            if(index == word.length()-1){
                return true;
            } else {
                visited[row][column] = true;

                boolean right = helper(board, word, index+1, visited, row+1, column);
                boolean left = helper(board, word, index+1, visited, row-1, column);
                boolean up = helper(board, word, index+1, visited, row, column-1);
                boolean down = helper(board, word, index+1, visited, row, column+1);

                visited[row][column] = false;

                return right || left || up || down;
            }
        } else {
            return false;
        }
    }

    private boolean isNotSafe(char[][] board, int r, int c) {
        return r<0 || c<0 || r >= board.length || c >= board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "ABCB";

        P2 p2 = new P2();
        System.out.println(p2.exist(board, word));
    }
}
