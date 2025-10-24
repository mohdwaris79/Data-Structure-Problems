
import java.util.*;

public class Zombie {

    // Directions: up, down, left, right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static int minHours(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int humans = 0;

        // Step 1: Add all initial zombies to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 0) {
                    humans++;
                }
            }
        }

        if (humans == 0) {
            return 0; // No humans to infect
        }
        int hours = 0;

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] zombie = queue.poll();
                int r = zombie[0], c = zombie[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + rowDir[d];
                    int nc = c + colDir[d];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1; // Human becomes zombie
                        humans--;
                        infectedThisRound = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            if (infectedThisRound) {
                hours++;
            }
        }

        return humans == 0 ? hours : -1; // if any human left, impossible
    }

    // Utility to print the grid
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };

        System.out.println("Initial Grid:");
        printGrid(grid);

        int result = minHours(grid);

        System.out.println("Grid after infection:");
        printGrid(grid);

        System.out.println("Minimum hours to infect all humans: " + result);
    }
}
