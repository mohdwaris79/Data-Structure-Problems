import java.util.*;
public class BinarySearch{
    public static int  binary(int arr[], int k)
    {
        Arrays.sort(arr);
        int st=0;
        int end=arr.length-1;
      
        while(st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==k)
            {
                return mid;
            }
            if(arr[mid]<k){
                st=mid+1;
            }else{
            end=mid-1;
            }
        }
        return -1;

    }
    public static void main(String args[])
    {
        int arr[]={4,5,6,2,8,9,10};
        int k=8;
        System.out.println(binary(arr,k));
    }
}