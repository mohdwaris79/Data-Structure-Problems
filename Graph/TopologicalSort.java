import java.util.*;

public class TopologicalSort {

    public static void dfs(int curr, boolean[] vis, Stack<Integer> st, List<Integer>[] graph) {
        vis[curr] = true;
        for (int neighbor : graph[curr]) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, st, graph);
            }
        }
        st.push(curr);
    }

    public static List<Integer> topoSort(int V, List<Integer>[] graph) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, graph);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!st.isEmpty()) {
            topo.add(st.pop());
        }
        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges 
        graph[5].add(2);
        graph[5].add(0);
        graph[4].add(0);
        graph[4].add(1);
        graph[2].add(3);
        graph[3].add(1);

        List<Integer> topo = topoSort(V, graph);
        System.out.println("Topological Sort: " + topo);
    }
}
