import java.util.*;
public class MajorityElement1 {
    public static int majorityElement(int arr[])
    {
        int n=arr.length;
        Arrays.sort(arr);
        return arr[n/2];
    }
    public static void main(String args[])
    {
        int arr[]={4,7,6,7,3,9,7};
        System.out.println(majorityElement(arr));
    }
    
}
