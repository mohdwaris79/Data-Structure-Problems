public class ZeroOnesKnapsack{
    public static int knapsack(int val[], int wt[], int W, int i, int dp[][])
    {
        int ans1=0;
        int ans2=0;
        if(i==0||W==0){
            return 0;
        }
        if(dp[i][W]!=-1)
        {
            return dp[i][W];
        }
        if(wt[i-1]<=W)
        {
            ans1= val[i-1]+knapsack(val, wt, W-wt[i-1], i-1, dp);
            ans2= knapsack(val, wt, W, i-1, dp);
            dp[i][W]=Math.max(ans1,ans2);
            return dp[i][W];
        }
        else{
            return dp[i][W]=knapsack(val, wt, W, i-1, dp);
        }

        

    }
    public static void main(String args[])
    {
        int val[]={40,50,60,30,20,70};
        int wt[]={7,2,6,9,8,3};
        int W=9;
        int dp[][]=new int [val.length+1][W+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
            
        }
        System.out.println(knapsack(val, wt, W, val.length, dp));
    }
}