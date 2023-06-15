package exam.codesignal.paypay;

public class Problem1 {
    int[][] solution(int h, int w, String[] queries) {

        int[][] grid = new int[h][w];
        String color = "x";
        String up = "^";
        String down = "v";
        String left = "<";
        String right = ">";

        int ansCount = 0;

        for(int i=0; i<queries.length; i++) {
            String query = queries[i];
            String[] queryArray = query.split(" ");


            String marker = queryArray[0];

            if(!marker.equals(color)){
                ansCount++;
            }
        }

        int[][] answer = new int[ansCount][2];
        ansCount = 0;
        for(int i=0; i<queries.length; i++) {
            String query = queries[i];
            String[] queryArray = query.split(" ");

            String marker = queryArray[0];
            int row = Integer.parseInt(queryArray[1]);
            int column = Integer.parseInt(queryArray[2]);

            if(marker.equals(color)) {
                colorGrid(grid, row, column);

            } else if(marker.equals(up)) {
                int[] ans = getDownMost(grid, row, column);
                answer[ansCount][0] = ans[0];
                answer[ansCount][1] = ans[1];
                ansCount++;
            } else if(marker.equals(down)) {
                int[] ans = getUpMost(grid, row, column);
                answer[ansCount][0] = ans[0];
                answer[ansCount][1] = ans[1];
                ansCount++;
            } else if (marker.equals(left)) {
                int[] ans = getRightMost(grid, row, column);
                answer[ansCount][0] = ans[0];
                answer[ansCount][1] = ans[1];
                ansCount++;
            } else if (marker.equals(right)) {
                int[] ans = getLeftMost(grid, row, column);
                answer[ansCount][0] = ans[0];
                answer[ansCount][1] = ans[1];
                ansCount++;
            }
        }

        return answer;
    }

    void colorGrid(int[][] grid, int r, int c){
        grid[r][c] = 1;
    }


    int[] getRightMost(int[][] grid, int r, int c) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i=0; i<c; i++) {
            if(grid[r][i] == 0) {
                ans[0] = r;
                ans[1] = i;
            }
        }

        return ans;
    }


    int[] getLeftMost(int[][] grid, int r, int c) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i=grid[0].length-1; i>c; i--) {
            if(grid[r][i] == 0) {
                ans[0] = r;
                ans[1] = i;
            }
        }
        return ans;
    }


    int[] getUpMost(int[][] grid, int r, int c) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        for(int i = grid.length-1; i>r; i--) {
            if(grid[i][c] == 0) {
                ans[0] = i;
                ans[1] = c;
            }
        }
        return ans;
    }


    int[] getDownMost(int[][] grid, int r, int c) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        for(int i = 0; i<r; i++) {
            if(grid[i][c] == 0) {
                ans[0] = i;
                ans[1] = c;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] queries = {"> 1 0",
                "v 0 1",
                "< 1 2",
                "^ 2 1",
                "x 1 1",
                "> 1 0",
                "v 0 1",
                "< 1 2",
                "^ 2 1"};

        Problem1 anns = new Problem1();
        anns.solution(3,3,queries);
    }
}
