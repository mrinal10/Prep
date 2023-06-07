package sixty.days.dsa.day7;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        fill(sr, sc, image, visited, color, image[sr][sc]);
        return image;
    }

    public void fill(int row, int col, int[][] grid, int[][] visited, int color, int prevColor) {
        if(!isSafe(row, col, grid)) {
            return;
        }

        if(visited[row][col]!=1) {
            visited[row][col] = 1;
            int pColor = grid[row][col];
            if(prevColor == pColor) {
                grid[row][col] = color;
                fill(row - 1, col, grid, visited, color, pColor);
                fill(row + 1, col, grid, visited, color, pColor);
                fill(row, col + 1, grid, visited, color, pColor);
                fill(row, col - 1, grid, visited, color, pColor);
            }
        }
    }

    private boolean isSafe(int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length - 1) {
            return false;
        }
        return true;
    }
}
