import java.util.*;

public class countNodes {
    
    public static void dfs(int curr, boolean[] vis, List<Integer>[] graph) {
        vis[curr] = true;
        for (int neighbor : graph[curr]) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, graph);
            }
        }
    }

    public static int count(int V, List<Integer>[] graph) {
        boolean[] vis = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, graph);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graph edges
        graph[0].add(1);
        graph[1].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(0);
        graph[0].add(3);

        System.out.println("Connected Components: " + count(V, graph));
    }
}
