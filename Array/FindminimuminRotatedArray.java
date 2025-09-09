public class FindminimuminRotatedArray {
    public static int find(int nums[])
    {
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]>right){
                left=mid+1;
            }
            right=mid;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int nums[]={1,3,4,5,6,7};
        System.out.println(find(nums));
    }
    
}
