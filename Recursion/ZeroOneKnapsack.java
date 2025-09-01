import java.util.*;


public class ZeroOneKnapsack {
    public static int knapsack(int val[], int wt[], int W, int i)
    {
       
        int ans1=0;
        int ans2=0;
        if(i==0||W==0)
        {
            return 0;
        }
        if(wt[i-1]<W)
        {
            //case:1
            ans1=val[i-1]+knapsack(val, wt, W-wt[i-1], i-1);
            ans2=knapsack(val,wt, W, i-1);
            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(val, wt, W, i-1);
        }
       
    }
    public static void main(String args[])
    {
        int val[]={10,15,16,12,20,45};
        int wt[]={4,5,6,1,2,9};
        int W=8;
        System.out.println(knapsack(val, wt, W, val.length));

    }
}
