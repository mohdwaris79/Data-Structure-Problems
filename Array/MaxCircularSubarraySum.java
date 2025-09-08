public class MaxCircularSubarraySum {
    public static int circular(int arr[])
    {
        int currMax=0;
        int currMin=0;
        int maxSum=0;
        int minSum=0;
        int totalSum=0;
        for(int i:arr)
        {
            currMax=Math.max(i, currMax+i);
            maxSum=Math.max(maxSum, currMax);


            currMin=Math.min(i, currMin+i);
            minSum=Math.min(minSum, currMin);
             totalSum+=i;
        }
             if(maxSum<0)

             {
                return maxSum;

             }
             int wrap=totalSum-minSum;
             maxSum=Math.max(maxSum, wrap);
        
       return  maxSum;
    }
    public static void main(String args[])
    {
        int arr[]={4,5,6,7,9,11};
        System.out.println(circular(arr));
    }
    
}
