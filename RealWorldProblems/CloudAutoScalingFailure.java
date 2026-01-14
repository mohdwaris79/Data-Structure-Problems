public class CloudAutoScalingFailure {
    


    public static int crashTime(
            int[] load,
            int baseCapacity,
            int[] scaleUp,
            int delay,
            int C) {

        int n = load.length;
        long capacity = baseCapacity;
        long backlog = 0;
        int crashStart = -1;

        // store how many servers activate at each second
        long[] activateAt = new long[n + delay + 1];

        // schedule activations
        for (int i = 0; i < n; i++) {
            if (scaleUp[i] > 0) {
                activateAt[i + delay] += (long) scaleUp[i] * C;
            }
        }

        for (int i = 0; i < n; i++) {

            // activate servers if any
            capacity += activateAt[i];

            // total work
            backlog += load[i];

            // process requests
            long processed = Math.min(capacity, backlog);
            backlog -= processed;

            // crash logic
            if (backlog > 0) {
                if (crashStart == -1) {
                    crashStart = i;
                }
            } else {
                crashStart = -1; // recovered
            }
        }

        return crashStart;
    }

    public static void main(String[] args) {

        int[] load = {10, 12, 15, 20, 18, 5, 5};
        int baseCapacity = 10;
        int[] scaleUp = {0, 1, 0, 1, 0, 0, 0};
        int delay = 2;
        int C = 5;

        System.out.println(crashTime(load, baseCapacity, scaleUp, delay, C));
    }
}
