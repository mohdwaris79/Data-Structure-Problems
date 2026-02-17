
public class OnlineExamSubmissionSync {

    public static int countBatches(int[] arr, int maxSum, int maxCount, int maxDistance) {

        int currentSum = 0;
        int currentCount = 0;
        int batchStartIndex = 0;
        int batches = 0;

        for (int i = 0; i < arr.length; i++) {

            // Check all constraints
            if (currentSum + arr[i] <= maxSum &&                              // current sum + element of array less than maxSum
                currentCount + 1 <= maxCount &&
                (i - batchStartIndex) <= maxDistance) {

                // Add to current batch
                currentSum += arr[i];
                currentCount++;              // increase the number of count
            } else {

                // Close current batch       // if batch exceeds the limit then close the current batch 
                batches++;

                // Start new batch
                batchStartIndex = i;
                currentSum = arr[i];
                currentCount = 1;
            }
        }

        // Count last batch
        if (currentCount > 0) {
            batches++;
        }

        return batches;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 3, 6};

        int maxSum = 10;
        int maxCount = 3;
        int maxDistance = 2;

        int result = countBatches(arr, maxSum, maxCount, maxDistance);

        System.out.println("Total Batches: " + result);
    }
}
