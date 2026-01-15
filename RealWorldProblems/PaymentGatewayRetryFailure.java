public abstract class PaymentGatewayRetryFailure {
    
// Sliding Window + Prefix Sum

    public static int permanentBlock(int[] failures, int W, int L) {

        long windowSum = 0;
        int breachStart = -1;

        for (int i = 0; i < failures.length; i++) {

            windowSum += failures[i];

            if (i >= W) {
                windowSum -= failures[i - W];
            }

            if (i >= W - 1) {
                if (windowSum > L) {
                    if (breachStart == -1) {
                        breachStart = i;
                    }
                } else {
                    breachStart = -1; // recovered
                }
            }
        }

        return breachStart;
    }

    public static void main(String[] args) {

        int[] failures = {1, 2, 3, 4, 2, 1, 1};
        int W = 3;
        int L = 5;

        System.out.println(permanentBlock(failures, W, L));
    }
}
