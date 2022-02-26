package dsalgo.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Course Schedule 2
public class Leetcode_210 {
    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if (!this.isPossible) {
            return;
        }
        this.color.put(node, GRAY);
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<>())) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.init(numCourses);

        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == WHITE) {
                this.dfs(i);
            }
        }

        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        Leetcode_210 l210 = new Leetcode_210();
        int[] ans = l210.findOrder(numCourses, prerequisites);
        for(int i : ans) {
            System.out.print(i+", ");
        }
    }
}
