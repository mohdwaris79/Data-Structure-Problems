
import java.util.*;
public class FibonacciSeries {
    public static int Fibonacci(int n, int dp[])
    {
       if(n==0)
       {
        return 1;
       }
       if(n==1)
       {
        return 1;

       }
       dp[n]=Fibonacci(n-1, dp)+Fibonacci(n-2, dp);
       return dp[n];
    }
    public static void main(String[] args) {
        int n=10;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(Fibonacci(n,dp));
    }
    
}
