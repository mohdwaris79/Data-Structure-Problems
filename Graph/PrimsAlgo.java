import java.util.*;

// Edge class
class Edge {
    int src, dest, wt;
    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

// Pair class for PQ
class Pair implements Comparable<Pair> {
    int v;    // vertex
    int cost; 

    public Pair(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.cost - p2.cost; 
    }
}

public class PrimsAlgo {
    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start with vertex 0
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                // add all neighbors of curr.v
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Final MST Cost = " + finalCost);
    }

    // helper to build graph
    public static void addEdge(ArrayList<Edge> graph[], int src, int dest, int wt) {
        graph[src].add(new Edge(src, dest, wt));
        graph[dest].add(new Edge(dest, src, wt)); // undirected
    }

    
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 15);
        addEdge(graph, 0, 3, 30);
        addEdge(graph, 1, 3, 40);
        addEdge(graph, 2, 3, 50);

        prims(graph);
    }
}
