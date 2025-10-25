import java.util.*;

class MinStepHalfSum {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;

        for (int num : arr) {
            pq.add((double) num);
            sum += num;
        }

        double target = sum / 2.0;
        int operations = 0;

        while (sum > target) {
            double largest = pq.poll();
            double reduced = largest / 2.0;
            sum -= reduced;
            pq.add(reduced);
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        MinStepHalfSum sum = new MinStepHalfSum();
        int[] arr = { 8, 6, 2 };
        System.out.println(sum.minOperations(arr)); // Output: 3
    }
}
