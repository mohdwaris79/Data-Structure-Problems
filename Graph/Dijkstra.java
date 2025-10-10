import java.util.*;

class Dijkstra{
    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    static int[] dijkstra(List<Edge>[] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                if (dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge>[] g = new ArrayList[V];
        for (int i = 0; i < V; i++) g[i] = new ArrayList<>();

        // Example graph (undirected)
        g[0].add(new Edge(1, 2)); g[1].add(new Edge(0, 2));
        g[0].add(new Edge(2, 4)); g[2].add(new Edge(0, 4));
        g[1].add(new Edge(2, 1)); g[2].add(new Edge(1, 1));
        g[1].add(new Edge(3, 7)); g[3].add(new Edge(1, 7));
        g[2].add(new Edge(4, 3)); g[4].add(new Edge(2, 3));

        int[] dist = dijkstra(g, 0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < V; i++)
            System.out.println("0 -> " + i + " = " + dist[i]);
    }
}
