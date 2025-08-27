import java.util.*;
public class LongestIncreasingSubsequence {
    
    public static int LongestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];      //first created a dp array
        Arrays.fill(dp, 0);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(LongestIncreasingSubsequence(nums)); // Output: 4
    }
}
