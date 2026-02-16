
public class MicroserviceMetricsAggregation {

    public static int minPushes(int[] metrics, int rateLimit) {

        int currentSum = 0;
        int pushes = 0;

        for (int metric : metrics) {

            // Edge case: single metric exceeds rate limit
            if (metric > rateLimit) {
                return -1; // Impossible to send
            }

            // If adding this metric exceeds limit,
            // finish current batch and start new one
            if (currentSum + metric > rateLimit) {
                pushes++;
                currentSum = metric;  // start new batch
            } else {
                currentSum += metric; // add to current batch
            }
        }

        // Add final batch if not empty
        if (currentSum > 0) {
            pushes++;
        }

        return pushes;
    }

    // Test
    public static void main(String[] args) {
        int[] metrics = {2, 5, 4, 3, 6};
        int rateLimit = 10;

        System.out.println("Minimum Pushes: " + minPushes(metrics, rateLimit));
    }
}
