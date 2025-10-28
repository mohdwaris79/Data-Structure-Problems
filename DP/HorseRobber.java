public class HorseRobber {
    public static int horseRobber(int num[])
    {
        int n=num.length;
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 0;
        }
        int dp[]=new int[n];
        dp[0]=0;
        dp[1]=Math.max(dp[0],dp[1]);
        for(int i=2;i<n;i++)
        {
           dp[i] = Math.max(dp[i-1], num[i] + dp[i-2]);

        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int n[]={4,5,6,7,8,9};
        System.out.println(horseRobber(n));
    }
}
