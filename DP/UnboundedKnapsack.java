public class UnboundedKnapsack{
    public static int knapsack(int val[], int wt[], int W)
    {
        int n=val.length;
        int dp[][]=new int [n+1][W+1];
       
        
            for(int i=1;i<n+1;i++)
            {
                for(int j=1;j<W+1;j++)
                {
                    if(wt[i-1]<=j)
                    {
                        dp[i][j]=Math.max(val[i-1]+ dp[i][j-wt[i-1]], dp[i-1][j]);
                    }
                    else{
                         dp[i][j]=dp[i-1][j];
                    }
                }
            }
            return dp[n][W];
    }
    public static void main(String args[])
    {
        int val[]={45,55,65,88,14,43};
        int wt[]={2,4,6,3,8,7};
        int W=12;
        System.out.println(knapsack(val, wt, W));
    }
}