import java.util.*;

public class MinCostRopes {

    public static int minCost(int[] arr) {
        // Step 1: Create a min-heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 2: Add all ropes to the heap
        for (int rope : arr) {
            pq.add(rope);
        }

        int totalCost = 0;

        // Step 3: Keep connecting ropes until one rope remains
        while (pq.size() > 1) {
            int first = pq.poll(); // smallest rope
            int second = pq.poll(); // second smallest rope

            int cost = first + second; // cost to connect
            totalCost += cost; // add to total cost

            pq.add(cost); // push new rope back into heap
        }

        // Step 4: Return total minimum cost
        return totalCost;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 6 };

        int result = minCost(arr);
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
