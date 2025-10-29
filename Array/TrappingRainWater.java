public class TrappingRainWater {

    public static int trappingRain(int height[]) {
        int n = height.length;
        if (n == 0) return 0;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int trap = 0;
        for (int i = 0; i < n; i++) {
            trap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trap;
    }

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("Trapped water (Example 1): " + trappingRain(height1)); 
        System.out.println("Trapped water (Example 2): " + trappingRain(height2)); 
    }
}
