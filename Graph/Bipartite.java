import java.util.*;

class Edge {
    int src, dest;

    Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

public class Bipartite {
    public static boolean bipartite(ArrayList<Edge>[] graph) {
        // create a color array
        int col[] = new int[graph.length];

        // initialize all vertices with no color
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; // first color

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } 
                        else if (col[e.dest] == col[curr]) {
                            return false; // same color neighbor → not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));

        System.out.println(bipartite(graph)); 
    }
}
