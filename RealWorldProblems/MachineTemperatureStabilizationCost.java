
import java.util.*;

public class MachineTemperatureStabilizationCost {

    public static long minCost(int[] temps, int k) {
        int n = temps.length;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i + k <= n; i++) {
            int[] window = new int[k];     // first: create window
            for (int j = 0; j < k; j++) {
                window[j] = temps[i + j];   // window will hold k elements
            }

            Arrays.sort(window);            // sort the window
            int median = window[k / 2];     // Find Median 

            long cost = 0;
            for (int val : window) {
                cost += Math.abs(val - median);         // elements of window - median of the temp
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temps = {1, 5, 2, 3, 7};
        int k = 3;
        System.out.println(minCost(temps, k));
    }
}
