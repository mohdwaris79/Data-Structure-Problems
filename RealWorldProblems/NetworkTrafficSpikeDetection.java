import java.util.*;

public class NetworkTrafficSpikeDetection {

    public static int countSpikes(int[] traffic, int k, int T) {
        int n = traffic.length;
        long sum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum += traffic[i];
        }

        if (sum > (long) k * T) count++;     // Condition: if average/k>sum then count the spike

        for (int i = k; i < n; i++) {
            sum += traffic[i];
            sum -= traffic[i - k];

            if (sum > (long) k * T) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int T = sc.nextInt();

        int[] traffic = new int[n];
        for (int i = 0; i < n; i++) traffic[i] = sc.nextInt();

        System.out.println(countSpikes(traffic, k, T));
        sc.close();
    }
}
