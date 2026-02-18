public class WidestVerticalPathForest {
    
       // Removing Sorting and applying pigeon hole principal for reducing time complexity from O(nlogn) to O(N).

       
    public static int forest(int[] X, int[] Y) {
        int n = X.length;           // we will focus on x because we want find max distance x between tree
        if (n < 2) return 0;        // trap case

        // Step 1: Find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : X) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;      // Naturally remove duplicate

        // Step 2: Calculate bucket size
        int bucketSize = (int) Math.ceil((double)(max - min) / (n - 1));       

        int bucketCount = n - 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Step 3: Distribute numbers into buckets
        for (int num : X) {
            if (num == min || num == max) continue;

            int index = (num - min) / bucketSize;

            bucketUsed[index] = true;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Step 4: Compute maximum gap
        int maxGap = 0;
        int previous = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;

            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }

        // Final gap with max
        maxGap = Math.max(maxGap, max - previous);

        return maxGap;
    }
     public static void main(String[] args) {
        int[] X = {8, 1, 7, 3, 4};
        int[] Y = {2, 5, 1, 6, 3};  // Y is irrelevant

        int result = forest(X, Y);

        System.out.println("Maximum Width of Vertical Path: " + result);
    }
}
