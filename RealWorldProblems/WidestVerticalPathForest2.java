
import java.util.*;
public class WidestVerticalPathForest2 {
    public static int forest(int x[], int y[])
    {
        Arrays.sort(x);
        int maxGap=0;

        for(int i=1;i<x.length;i++)
        {
            int gap =x[i]-x[i-1];

            if(gap>maxGap)
            {
                maxGap=gap;
            }
        }
        return maxGap;
    }
     public static void main(String[] args) {
        int[] X = {8, 1, 7, 3, 4};
        int[] Y = {2, 5, 1, 6, 3};  // Y is irrelevant

        int result = forest(X, Y);

        System.out.println("Maximum Width of Vertical Path: " + result);
    }
    
}
