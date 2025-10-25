
import java.util.*;

public class TwoSumUnsorted {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();    // we use HashMap because we have unsorted array

        for (int i = 0; i < nums.length; i++) {             // Read the array
            int needed = target - nums[i]; // number we still need

            if (map.containsKey(needed)) {
                

                // found the number
                return new int[]{map.get(needed), i};
            }

            // store number with its index
            map.put(nums[i], i);
        }

        // if not found 
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
