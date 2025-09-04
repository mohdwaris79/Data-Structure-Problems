public class LinearSearch{
    public static boolean  linear(int arr[],int k)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==k)
            {
                return true;
            }
            
        }
        return false;
    }
    public static void main(String args[])
    {
        int arr[]={4,5,6,2,7,8,9};
        int k=2;
        if(linear(arr,k))
        {
            System.out.println(k+"as a key is found");
        }
         
}
    
}