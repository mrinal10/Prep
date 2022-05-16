package important450.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RatInMaze {

    static ArrayList<String> paths;
    static Set<String> visited;

    public static ArrayList<String> findPath(int[][] m, int n) {
        paths = new ArrayList<>();
        visited = new HashSet<>();

        findPath(m, "", 0, 0, n);

        return paths;
    }

    public static void findPath(int[][] m, String path,
                                int row, int col, int n) {
        if (row >= n || row < 0
                || col >= n || col < 0
                || m[row][col] == 1) {
            return;
        }
        String key = row+"|"+col;
        if(visited.contains(key))
            return;
        visited.add(key);
        if(row == n-1 && col == n-1)
            paths.add(path);

        findPath(m, path + 'U',row - 1, col, n);
        findPath(m, path + 'D',row + 1, col, n);
        findPath(m, path + 'L', row, col - 1, n);
        findPath(m, path + 'R', row, col + 1, n);

        visited.remove(key);
    }
}