public class SmallestSubarrayWithSumGreaterThanK {
    public static int SubArray(int arr[], int k)
    {
        int n=arr.length;
        int left=0;  int sum=0;
        int minLen=Integer.MAX_VALUE;
        for(int right=0;right<n;right++)
        {
            sum+=arr[right];
        
        while(sum>=k)
        {
             minLen = Math.min(minLen, right - left + 1);

            sum=sum-arr[left];
            left++;
        }
        }
        return minLen;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int k=10;
        System.out.println(SubArray(arr, k));
    }
    
}
