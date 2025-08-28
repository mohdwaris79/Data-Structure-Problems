
import java.util.Arrays;

public class CountTriangles {
    
    public static int count(int arr[])
    {
        int n=arr.length;
        int count=0;
        
        Arrays.sort(arr);
        for(int k=n-1;k>=2;k--)
        {
            int i=0;
        int j=k-1;
        while(i<j)
        {
           if (arr[i] + arr[j] > arr[k]) { 
                count+=(j-i);
                j--;
            }
            else{
                i++;
            }
        }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,2};
        System.out.println(count(arr));
    }
}
