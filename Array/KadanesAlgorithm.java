public class KadanesAlgorithm {
    public static int  SubArraySum(int arr[])
    {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i:arr)
        {
            currSum=Math.max(i,currSum+i);
            maxSum=Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={1,5,6,8,-2,-9,6,-1};
        System.out.println(SubArraySum(arr));
    }
    
}
