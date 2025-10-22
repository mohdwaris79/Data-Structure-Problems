
import java.util.*;

public class RottenOrange {

    
    static class Pair {
        int row, col, time;
        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int freshCount = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0)); 
                } else if (grid[i][j] == 1) {
                    freshCount++; 
                }
            }
        }

       
        if (freshCount == 0) return 0;

        int time = 0;
        int[] dRow = {-1, 0, 1, 0}; 
        int[] dCol = {0, 1, 0, -1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // mark as rotten
                    freshCount--;
                    q.add(new Pair(nr, nc, t + 1));
                }
            }
        }

        // If any fresh orange remains
        return (freshCount == 0) ? time : -1;
    }

    
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = orangesRotting(grid);
        if (result == -1) {
            System.out.println("All oranges cannot become rotten.");
        } else {
            System.out.println("Minimum time required: " + result);
        }
    }
}
