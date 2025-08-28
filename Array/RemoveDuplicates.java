public class  RemoveDuplicates {
    public static int Duplicates(int arr[])
    {
        int slow=0;
        int n=arr.length;
        for(int fast=1;fast<n;fast++)
        {
            if(arr[fast]!=arr[slow])
            {
                slow++;
            }
            arr[slow]=arr[fast];

        }
        return slow;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,2,8,4,9};
        System.out.println(Duplicates(arr));
    }
    
}
