package amazon;

public class MinPathSum {

    public int minPathSum(int[][] grid) {

        return minPathUtil(grid, 0, 0);
    }

    public int minPathUtil(int[][] grid, int row, int col) {

        if(row == grid.length-1 && col == grid[0].length - 1)
            return grid[row][col];

        if(row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        return  grid[row][col] + Math.min(minPathUtil(grid, row+1, col), minPathUtil(grid, row, col+1));
    }

}
