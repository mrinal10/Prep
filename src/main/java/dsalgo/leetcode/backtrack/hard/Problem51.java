package dsalgo.leetcode.backtrack.hard;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    char[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i=0; i < n; i++) {
            for(int j = 0; j < n; j++) {
               board[i][j] = '.';
            }
        }

        result = new ArrayList();
        for(int i=0; i < n; i++) {
            recursiveHelper(n, 0, i);
        }
        return result;
    }

    private void recursiveHelper(int remainingQueenCount, int curRow, int curColumn) {
        if(remainingQueenCount == 0) { //Achieved
            result.add(getRowsList(board));
            return;
        }

        board[curRow][curColumn] = 'Q';
        recursiveHelper(remainingQueenCount - 1, curRow + 1, curColumn + 1);
        board[curRow][curColumn] = '.';
    }

    private boolean isSafe(char[][] board, int row, int column) {
        int dimension = board.length;
        if(row<0 || row>= dimension || column<0 || column>= dimension) {
            return false;
        }
        //check particular row
        for(int i=0; i<dimension; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }

        //check particular column
        for(int i=0; i<dimension; i++) {
            if(board[i][column] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> getRowsList(char[][] matrix) {
        List<String> eachRowList = new ArrayList();
        for(int i=0; i < matrix.length; i++) {
            String s = "";
            for(int j = 0; j < matrix[0].length; j++) {
                s += matrix[i][j];
            }
            eachRowList.add(s);
        }
        return eachRowList;
    }


    public static void main(String[] args) {
        Problem51 p51 = new Problem51();
        p51.solveNQueens(9);
    }

}
