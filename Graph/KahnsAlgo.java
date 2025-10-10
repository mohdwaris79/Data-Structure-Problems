import java.util.*;

public class KahnsAlgo {

    // Edge class
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to calculate indegree of all vertices
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int V = i;
            for (int j = 0; j < graph[V].size(); j++) {
                Edge e = graph[V].get(j);
                indeg[e.dest]++;
            }
        }
    }

    // Topological Sort using Kahn's Algorithm
    public static void topSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calcIndeg(graph, indeg);

        // add all nodes with indegree 0
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        int V = 6; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create a sample DAG
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        System.out.println("Topological Sort (Kahn's Algorithm):");
        topSort(graph);
    }
}
