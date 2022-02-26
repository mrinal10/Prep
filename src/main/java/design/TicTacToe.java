package design;

public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (rows.length - row - 1)) {  
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}

class AppTester {

    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe(3);

        t1.move(0,0,1);
        t1.move(0,2,2);
        t1.move(2,2,1);
        t1.move(1,1,2);
        t1.move(2,0,1);
        t1.move(1,0,2);
        System.out.println(t1.move(2,1,1));
    }
}
