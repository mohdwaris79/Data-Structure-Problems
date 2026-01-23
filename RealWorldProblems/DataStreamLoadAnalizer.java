
    
public class DataStreamLoadAnalizer {

    public static int countViolations(int[] events, int k, int L) {
        int n = events.length;
        long sum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {   // sum only of window size k
            sum += events[i];
        }

        if (sum > L) count++;

        for (int i = k; i < n; i++) {
            sum += events[i];
            sum -= events[i - k];
            if (sum > L) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] events = {5, 3, 8, 2, 6};
        int k = 2;
        int L = 10;

        System.out.println(countViolations(events, k, L));
    }
}
