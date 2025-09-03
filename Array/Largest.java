public class Largest {
    public static int largest(int arr[])
    {
        int largest=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(largest<arr[i])
            {
                largest=arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr[]={4,5,65,78,89,23,100};
        System.err.println(largest(arr));
    }
}
