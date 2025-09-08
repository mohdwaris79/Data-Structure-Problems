public class SmallestSubarrayWithSumLessThanK {
    public static int SubArray(int arr[], int k)
    {
        int left=0; int maxLen=0; int sum=0;
        int n=arr.length;
        for(int right=0;right<n;right++)
        {
            sum+=arr[right];
            while(sum>k)
            {
                sum=sum-arr[left];
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);

        }
        return maxLen;

    }
    
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5,9};
        int k=6;
        System.out.println(SubArray(arr, k));
    }
    
}
