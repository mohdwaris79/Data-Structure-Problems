
import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // check if prefixSum - k has appeared before
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // update map with current prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 1, 2};
        int k = 3;
        System.out.println(subarraySum(arr, k)); // Output: 4
    }
}
