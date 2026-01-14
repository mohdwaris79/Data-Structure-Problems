public class StockExchangeOrderImbalance {

    public static int crashTime(int[] events, int K) {

        long balance = 0;
        int crashStart = -1;

        for (int i = 0; i < events.length; i++) {

            balance += events[i];

            if (Math.abs(balance) > K) {
                if (crashStart == -1) {
                    crashStart = i;
                }
            } else {
                crashStart = -1; // recovered
            }
        }

        return crashStart;
    }

    public static void main(String[] args) {

        int[] events = {5, 7, -3, -2, 10, -1, -1};
        int K = 8;

        System.out.println(crashTime(events, K));
    }
}

