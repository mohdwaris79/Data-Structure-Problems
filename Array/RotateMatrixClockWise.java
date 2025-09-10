public class RotateMatrixClockWise {
    public static void Rotate(int matrix[][])
    {
        int n=matrix.length-1;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++)
        {
            int left=0;
            int right=matrix.length-1;
            while(left<right)
            {
                int temp=matrix[i][left];
                matrix[i][left]=matrix[right][i];
                matrix[right][i]=temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int matrix[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        Rotate(matrix);

        // Print rotated matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    
    }
}
