public class SubarraySumOfSizeK {
    public static int SubArray(int arr[], int k)
    {
        int n=arr.length;
        int maxSum=0;
        int currSum=0;
        for(int i =0;i<k;i++)
        {
            maxSum+=arr[i];
        }
        currSum=maxSum;
        for(int i=k;i<n;i++)
        {
            currSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,currSum);
        

        }

        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,8,9,15};
        int k=3;
        System.out.println(SubArray(arr, k));
    }
    
}
