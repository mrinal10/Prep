package dsalgo.leetcode.topological_sort;

import java.util.ArrayList;

public class TopologicalSort {

    private int V;

    private ArrayList<ArrayList<Integer>> adjacencyList;

    TopologicalSort(int v) {
        V = v;
        adjacencyList = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adjacencyList.add(new ArrayList<Integer>());
    }

    void addEdge(int v, int w) { adjacencyList.get(v).add(w); }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
       // g.topologicalSort();

    }
}
