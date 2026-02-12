
import java.util.*;

public class PowerGridLoadBalancing {

    static class Edge {

        int node;
        double loss;  // loss factor 

        Edge(int node, double loss) {
            this.node = node;
            this.loss = loss;
        }
    }

    static List<List<Edge>> graph;
    static int[] demand;
    static boolean[] visited;

    public static double dfs(int node) {
        visited[node] = true;

        double totalRequired = demand[node];

        for (Edge edge : graph.get(node)) {
            int child = edge.node;
            double loss = edge.loss;

            if (!visited[child]) {
                double childNeed = dfs(child);

                // Adjust for transmission loss
                double adjusted = childNeed * (1 + loss);

                totalRequired += adjusted;
            }
        }

        return totalRequired;
    }

    public static double minimumPowerRequired(int n, int[][] edges, double[] loss, int[] demandArr) {

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double l = loss[i];

            graph.get(u).add(new Edge(v, l));
            graph.get(v).add(new Edge(u, l));
        }

        demand = demandArr;
        visited = new boolean[n];

        return dfs(0); // root is 0
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {1, 3}
        };

        double[] loss = {0.1, 0.2, 0.3};  // 10%, 20%, 30%

        int[] demand = {5, 10, 20, 15};

        double result = minimumPowerRequired(n, edges, loss, demand);

        System.out.println("Minimum Power Required at Root: " + result);
    }
}
