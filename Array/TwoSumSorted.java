import java.util.Arrays;

public class TwoSumSorted{
    public static int[] TwoSum(int arr[], int k){
        int left=0;
        int right=arr.length-1;
        int sum=0;
        while(left<right)
        {
            sum=arr[left]+arr[right];
            if(sum==k)
            {
                return new int[]{left, right};
            }
            if(sum<k)
            {
                left++;

            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int k=4;
        System.out.println(Arrays.toString(TwoSum(arr, k)));
    }
}