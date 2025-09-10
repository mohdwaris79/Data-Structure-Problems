public class MatrixMultiplication {
    public static void main(String[] args) {
        // Example matrices
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        // Dimensions
        int rowsA = A.length;        // 2
        int colsA = A[0].length;     // 3
        int rowsB = B.length;        // 3
        int colsB = B[0].length;     // 2
        
        
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible!");
            return;
        }
        
        
        int[][] C = new int[rowsA][colsB];
        
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        // Print result
        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
