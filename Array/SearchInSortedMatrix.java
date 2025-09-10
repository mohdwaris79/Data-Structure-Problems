public class SearchInSortedMatrix {
    public static boolean search(int matrix[][], int k) {
        int row = 0;
        int col = matrix[0].length - 1; 

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == k) {
                return true;
            } else if (matrix[row][col] > k) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13,14,15,16}
        };
        int k = 11;
        System.out.println(search(matrix, k)); // ✅ true
    }
}
