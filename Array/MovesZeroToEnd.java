public class MovesZeroToEnd {
    public static int swapZero(int arr[])
    {
        int slow=0;
        int n=arr.length;
        for(int fast=0;fast<n;fast++)
        {
            if(fast!=0)
            {
                //swap
                int temp=arr[fast];
                arr[fast]=arr[slow];
                arr[slow]=temp;
                slow++;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,2,8,9,10,1,5};
        System.out.println(swapZero(arr));
    }
    
    
}
