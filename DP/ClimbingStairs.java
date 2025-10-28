import java.util.*;
public class ClimbingStairs{
    public static int clbStairs(int n,int dp[])
    {
        
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        dp[n]=clbStairs(n-1,dp)+clbStairs(n-2,dp);
    
    return dp[n];
    }

public static void main(String args[])
{
    int n=5;
    int dp[]=new int[n+1];
    Arrays.fill(dp,-1);
    System.out.println(clbStairs(n,dp));
}
}