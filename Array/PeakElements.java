public class PeakElements {
    public static int peak(int arr[])
    {
        
        int left=0;
        int right=arr.length-1;
        
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<arr[mid+1])
            {
                left=mid+1;
            }
            else{
                right=mid;
            }

        }
        return left;
    }
public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(peak(arr)); 
        
    }
}
