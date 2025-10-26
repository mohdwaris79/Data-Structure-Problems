
import java.util.*;

public class Median {

    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // smaller half
        private PriorityQueue<Integer> minHeap; // larger half

        public MedianFinder() {
            // Max-Heap: store smaller half
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // Min-Heap: store larger half
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // Step 1: Add to maxHeap by default
            maxHeap.add(num);

            // Step 2: Ensure order property
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            // Step 3: Balance heaps (size difference ≤ 1)
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                // even number of elements → average
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0
    }
}
