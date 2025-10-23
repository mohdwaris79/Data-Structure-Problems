// Problem statement: find the maximum length of subsequence

// Approach: We will follow bottom up approach(comparing elements of the strings from the last)

// Case 1: Condition when element get matched then increase the length by 1.

// Case 2: Codition when element did not matched then we will divide the into two cases and remove element one by one from both 

// strings in different cases


public class LCS{
    public static int lcs(String s1, String s2, int m, int n, int dp[][])
    {
        if(n==0|| m==0)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        
        //Case1:

        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            return dp[m][n]= lcs(s1, s2, m-1, n-1, dp)+1;
        }

        // Case 2:
        else{
            int ans1=lcs(s1, s2, m-1, n, dp);
            int ans2=lcs(s1, s2, m, n-1, dp);
            return dp[m][n]= Math.max(ans1, ans2);


        }
    }
    public static void main(String[] args) {
        String s1="abcdef";
        String s2="abedg";
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int [m+1][n+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs(s1, s2, m, n, dp));
    }
}


