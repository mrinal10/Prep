package salesforce;

import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class CountConnectedComponents {
    
    private static class Graph {

        private int vertices; 
        private LinkedList<Integer>[] adj; 
        private ArrayList<ArrayList<Integer> > components;
        
        public Graph(int v) {
            vertices = v;
            adj = new LinkedList[vertices];

            for(int i=0; i<vertices; i++) {
                adj[i] = new LinkedList<>();
            }
            components = new ArrayList<>();
        }

        int ConnectedComponents() { 
            return components.size(); 
        }
        
        void addEdge(int u, int w) {
            adj[u].add(w);
            adj[w].add(u); 
        }

        public void DFS() {
            boolean[] visited = new boolean[vertices];

            for(int i=0; i<vertices; i++) {
                ArrayList<Integer> linkedNodes = new ArrayList<>();
                if(!visited[i]) {
                    DFSUtil(i, visited, linkedNodes);
                    components.add(linkedNodes);
                }
            }
        }

        private void DFSUtil(int index, boolean[] visited, 
                                    ArrayList<Integer> linkedNodes) {
            
            visited[index] = true;
            linkedNodes.add(index);

            java.util.Iterator it = adj[index].iterator();

            while(it.hasNext()) {
                int n = (int) it.next();
                if(!visited[n]) {
                    DFSUtil(n, visited, linkedNodes);
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(6);

		g.addEdge(1, 5);
		g.addEdge(0, 2);
		g.addEdge(2, 4);
		System.out.println("Graph DFS:");
		g.DFS();
		System.out.println(
			"\nNumber of Connected Components: "
			+ g.ConnectedComponents());
    }
}
