import java.util.*;
public class HighFrequencyTransactionThrottling {
    

    static class FraudDetector {
        private Queue<Integer> queue = new LinkedList<>();

        public boolean addTransaction(int timestamp) {

            // Add new transaction
            queue.offer(timestamp);

            // Remove transactions older than 5 seconds
            while (!queue.isEmpty() && timestamp - queue.peek() > 5) {
                queue.poll();
            }

            // Check suspicious condition
            if (queue.size() >= 3) {
                return true;   // suspicious
            }

            return false;
        }
    }

    public static void main(String[] args) {

        FraudDetector detector = new FraudDetector();

        int[] stream = {1, 2, 3, 7, 8, 9};

        for (int t : stream) {
            boolean result = detector.addTransaction(t);
            System.out.println("At time " + t + " suspicious? " + result);
        }
    }
}
