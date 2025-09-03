public class IndexesSubarraySum {
    public static int[] subarraySum(int[] arr, int target) {
        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

           
            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

           
            if (sum == target) {
                return new int[]{start + 1, end + 1}; 
            }
        }
        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        int[] result = subarraySum(arr, target);

        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}
