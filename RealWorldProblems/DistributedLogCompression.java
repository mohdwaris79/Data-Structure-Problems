 
import java.util.*;

public class DistributedLogCompression {

    long totalCost = 0;   
    int C;                // Batch capacity 
    int[] logs;           // Logs generated at each server in mb and for transfer it will convert in batches
    List<List<int[]>> graph; // Adjacency list: [neighbor, edgeCost]

    public long minimumTransferCost(int[][] edges, int[] edgeCost, int[] logs, int capacity) {
        
        int n = logs.length;
        this.C = capacity;
        this.logs = logs;

        // Build adjacency list
        graph = new ArrayList<>();

        // Apply loop on the logs
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());                  // create an empty arraylist for logs
        }

        for (int i = 0; i < edges.length; i++) {        
            int u = edges[i][0];                           // transfering on both way
            int v = edges[i][1];
            int cost = edgeCost[i];

            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }

        // Start DFS from root (server 0)
        dfs(0, -1);                     

        return totalCost;
    }

    private long dfs(int node, int parent) {

        long totalLogs = logs[node];  // Start with own logs

        for (int[] neighbor : graph.get(node)) {

            int next = neighbor[0];
            int cost = neighbor[1];

            if (next == parent) continue;

            long childLogs = dfs(next, node);

            // Compute batches needed for this child subtree
            long batches = (childLogs + C - 1) / C;

            // Add cost for this edge
            totalCost += batches * cost;

            // Aggregate logs
            totalLogs += childLogs;
        }

        return totalLogs;
    }
public static void main(String[] args) {
    FactoryShiftCarpool2 fsc = new FactoryShiftCarpool2();

   
    int[][] roads = {
        {0, 1},
        {1, 2},
        {1, 3}
    };

    // c[i] = number of people at node i
    int[] c = {1, 2, 3, 9};
    int[] weights = {1, 2, 3};  // fuel cost for each road


    long result = fsc.minimumFuelCost(roads,weights, c);
    System.out.println("Minimum Fuel Cost: " + result);
}
}
