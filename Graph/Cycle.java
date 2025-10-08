import java.util.*;

class Edge {
    int src;
    int dest;

    Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

public class Cycle {
    public static boolean detect(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycle(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (detectCycle(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != par) {
                // visited neighbor that is not the parent → cycle
                return true;
            }
        }
        return false;
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // undirected edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3)); 
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        if (detect(graph)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle");
        }
    }
}
