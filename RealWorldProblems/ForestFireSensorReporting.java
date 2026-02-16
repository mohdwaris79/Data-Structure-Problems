public class ForestFireSensorReporting {

    public static int minTransmissionCycles(int[] data, int bandwidthLimit, int maxSensorsPerCycle) {

        int currentSum = 0;
        int currentCount = 0;
        int cycles = 0;

        for (int size : data) {

            
            if (size > bandwidthLimit) {
                return -1; 
            }

            // Check if we can add this sensor to current cycle
            if (currentSum + size <= bandwidthLimit
                    && currentCount + 1 <= maxSensorsPerCycle) {

                currentSum += size;
                currentCount++;

            } else {
              
                cycles++;

                // Start new cycle with current sensor
                currentSum = size;
                currentCount = 1;
            }
        }

        // Add last cycle if not empty
        if (currentCount > 0) {
            cycles++;
        }

        return cycles;
    }

    
    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 5};
        int bandwidthLimit = 10;
        int maxSensorsPerCycle = 2;

        System.out.println("Minimum Cycles: "
                + minTransmissionCycles(data, bandwidthLimit, maxSensorsPerCycle));
    }
}
