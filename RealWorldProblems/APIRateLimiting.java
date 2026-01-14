public class APIRateLimiting {
    


    // Returns earliest second when user gets permanently blocked
    public static int permanentBlockTime(int[] requests, int W, int L) {

        long windowSum = 0;     // sum of requests in last W seconds
        int breachStart = -1;   // start time of continuous breach

        for (int i = 0; i < requests.length; i++) {

            // add current second's requests
            windowSum += requests[i];

            // remove request count W seconds ago
            if (i >= W) {
                windowSum -= requests[i - W];
            }

            // check only when window size is W
            if (i >= W - 1) {

                if (windowSum > L) {
                    // breach starts
                    if (breachStart == -1) {
                        breachStart = i;
                    }
                } else {
                    // recovered → reset breach
                    breachStart = -1;
                }
            }
        }

        return breachStart;                           // Return Earliest Second when system gone breach
    }

    
    public static void main(String[] args) {

        int[] requests = {3, 5, 2, 6, 7, 1, 1};
        int W = 3;
        int L = 10;

        int result = permanentBlockTime(requests, W, L);

        if (result == -1) {
            System.out.println("User is NOT permanently blocked");
        } else {
            System.out.println("User permanently blocked at second: " + result);
        }
    }
}
