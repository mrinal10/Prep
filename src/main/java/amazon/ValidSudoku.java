package amazon;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;

        Set<Character>[] rowSet = new HashSet[r];
        Set<Character>[] colSet = new HashSet[r];
        Set<Character>[] gridSet = new HashSet[r];

        for (int i = 0; i < r; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            gridSet[i] = new HashSet<Character>();
        }

        for(int row = 0; row < r; row++) {
            for (int col = 0; col < r; col++) {
                char value = board[row][col];
                if(value == '.') {
                    continue;
                }

                Set<Character> rowS = rowSet[row];
                if(rowS.contains(value)) {
                    return false;
                }
                rowS.add(value);
                rowSet[row]= rowS;

                Set<Character> colS = colSet[col];
                if(colS.contains(value)) {
                    return false;
                }
                colS.add(value);
                colSet[col] = colS;

                int gridIndex = (col/3)*3 + row/3;
                Set<Character> gridS = gridSet[gridIndex];
                if(gridS.contains(value)) {
                    return false;
                }
                gridS.add(value);
                gridSet[gridIndex] = gridS;
            }
        }

        return true;
    }


}
