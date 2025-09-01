
public class TilingProblem {
    public static int Tiling(int n)
    {
        if(n==0){
            return 1;
        }
        if(n==1)
        {
            return 1;
        }
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];

        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        //int dp[]=new int[n+1];
       System.out.println("Number of ways to tile 2 x " + n + " board = " + Tiling(n));
    }
}
