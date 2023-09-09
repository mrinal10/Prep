class Solution {

    // can we go up
    boolean isUp(int val) {
        return val == 2 || val == 5 || val == 6;
    }
    //can we go left
    boolean isLeft(int val) {
        return val == 1 || val == 3 || val == 5;
    }
    //can we go down
    boolean isDown(int val) {
        return val == 2 || val == 3 || val == 4;
    }
    //can we go right
    boolean isRight(int val) {
        return val == 1 || val == 4 || val == 6;
    }
    
    boolean isPath(int[][] grid, int x, int y, int m, int n, char sign) {
        if(!(x<m && x>=0 && y<n && y>=0 && grid[x][y] != -1)) {
            return false;
        }
        
        if(!(x==0 && y==0)) {
              if(sign == 'U' && !isDown(grid[x][y]))
                  return false;
              else if(sign == 'L' && !isRight(grid[x][y]))
                  return false;
              else if(sign == 'D' && !isUp(grid[x][y]))
                  return false;
              else if(sign == 'R' && !isLeft(grid[x][y]))
                  return false;
        }
        
        //check if destination cell reached
        if(x==m-1 && y==n-1)
            return true;
        
        
        int val = grid[x][y];
        grid[x][y] = -1;
      
        if(isUp(val) && isPath(grid, x-1, y, m, n, 'U'))
            return true;
        if(isLeft(val) && isPath(grid, x, y-1, m, n, 'L'))
            return true;
        if(isDown(val) && isPath(grid, x+1, y, m, n, 'D'))
            return true;
        if(isRight(val) && isPath(grid, x, y+1, m, n, 'R'))
            return true;
        
        grid[x][y] = val;
        
        return false;
    }
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
           
        return isPath(grid, 0, 0, m, n, '0');
    }
}