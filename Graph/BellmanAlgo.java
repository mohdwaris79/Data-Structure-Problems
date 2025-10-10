import java.util.*;

class BellmanAlgo{
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u=u; this.v=v; this.w=w; }
    }

    static int[] bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

       
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        // Detect negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int[] dist = bellmanFord(V, edges, 0);

        if (dist != null) {
            System.out.println("Shortest distances from node 0:");
            for (int i = 0; i < V; i++)
                System.out.println("0 -> " + i + " = " + dist[i]);
        }
    }
}
