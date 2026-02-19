public class FraudBurstDetection {

    public static long fraud(int A[], int k) {
        int n = A.length;
        long windowSum = 0;
         if (A == null || n == 0 || k > n || k <= 0) {
            return 0;
        }
        

        for (int i = 0; i < k; i++) {
            windowSum += A[i];
        }
        long maxSum=windowSum;
        for (int i = k; i < n; i++) {
            windowSum = windowSum - A[i - k] + A[i];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int A[] = { 4, 5, 6, 8, 2, 9 };
        int k=3;
        System.out.println(fraud(A,k));
    }
}