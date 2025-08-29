import java.util.Arrays;

class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

       
        reverse(nums, i + 1, n - 1);
    }

    public  static  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public  static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,3,2,5,9,8,7,1};

        nextPermutation(arr); 
        System.out.println(Arrays.toString(arr));
        
    }
}
