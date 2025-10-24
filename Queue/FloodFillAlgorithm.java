

public class FloodFillAlgorithm {

    // Directions: up, down, left, right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor != newColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;

        // Check if this pixel is the color we need to change
        if (image[r][c] != originalColor)
            return;

        // Change color
        image[r][c] = newColor;

        // Visit all 4 neighbors
        for (int i = 0; i < 4; i++) {
            dfs(image, r + rowDir[i], c + colDir[i], originalColor, newColor);
        }
    }

    // Utility function to print the image
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        System.out.println("Original Image:");
        printImage(image);

        int sr = 1, sc = 1, newColor = 2;
        floodFill(image, sr, sc, newColor);

        System.out.println("Image after Flood Fill:");
        printImage(image);
    }
}
