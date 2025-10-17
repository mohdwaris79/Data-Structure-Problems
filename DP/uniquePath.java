import java.util.*;

public class uniquePath {
    public static int path(int m, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, 1); 

        for (int i = 1; i < m; i++) {     
            for (int j = 1; j < n; j++) { 
                dp[j] = dp[j] + dp[j-1]; // add top + left
            }
        }
        return dp[n-1];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter m (rows): ");
        int m = sc.nextInt();
        
        System.out.print("Enter n (columns): ");
        int n = sc.nextInt();
        
        int result = path(m, n);
        System.out.println("Number of unique paths: " + result);
        
        sc.close();
    }
}
