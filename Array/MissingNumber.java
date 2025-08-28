public class MissingNumber{
    public static int missingNum(int arr[],int n)
    {
        int sum=0;
        int total=n*(n+1)/2;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return total-sum;

    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,5,6,7};
        int n=7;
        System.out.println(missingNum(arr,n));
    }
}