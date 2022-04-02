package adhoc;

import java.util.*;

public class Egnyte2 {
    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;
    public boolean solution(int[] from, int[] to) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        int numberOfNodes = from.length;

        for (int i = 0; i < numberOfNodes; i++) {
            int fromIndex = from[i];
            List<Integer> ll = new ArrayList<>();
            if(graph.containsKey(fromIndex)) {
                ll = graph.get(fromIndex);
            }
            ll.add(to[i]);
            graph.put(fromIndex, ll);
        }

        for(int i=1 ; i<=numberOfNodes; i++) {
            visited = new HashSet<>();
            if(isCyclicUtil(i, i, numberOfNodes)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int startIndex, int startPoint, int n) {
        if(!graph.containsKey(startIndex)) {
            return false;
        }
        if(visited.contains(startIndex) && startIndex==startPoint) {
            return visited.size() == n;
        }
        if(visited.contains(startIndex)) {
            return false;
        }
        visited.add(startIndex);
        List<Integer> toIndexes = graph.get(startIndex);
        for(int i : toIndexes) {
            boolean flag = isCyclicUtil(i, startPoint, n);
            if(flag) {
                return flag;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] from = {1, 2, 3, 4};// {1, 2, 1};//{1,2,3,4};//{1,3,2,4};
        int[] to = {2, 1, 4, 4};// {2, 3, 3};//{2,1,4,3};//{4,1,3,2};

        Egnyte2 egn2 = new Egnyte2();
        System.out.println(egn2.solution(from, to));
    }
}
