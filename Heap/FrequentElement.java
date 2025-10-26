
    
import java.util.*;

public class FrequentElement {
    
    public static List<Integer> topKFrequent(int[] arr, int k) {
        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Min Heap to store top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Step 3: Keep heap size at most K
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll(); // remove element with lowest frequency
            }
        }
        
        
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        
        //  reverse to show highest frequency first
        Collections.reverse(result);
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        List<Integer> res = topKFrequent(arr, k);
        System.out.println("Top " + k + " frequent elements: " + res);
    }
}
