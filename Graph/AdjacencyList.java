import java.util.*;

class   AdjacencyList{
    public static ArrayList<ArrayList<Integer>> printGraph(int V, int edges[][]) {
        // Step 1: Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u); // because graph is undirected
        }

        return adj;
    }


    public static void main(String[] args) {
        int V = 5, E = 7;
        int edges[][] = {
            {0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}
        };

        ArrayList<ArrayList<Integer>> res = printGraph(V, edges);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(i + " -> ");
            for (int val : res.get(i)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
