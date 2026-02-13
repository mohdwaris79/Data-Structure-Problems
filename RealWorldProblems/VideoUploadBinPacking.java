import java.util.*;

public class VideoUploadBinPacking {

    public static int minUploads(int[] chunks, int capacity) {

        // Step 1: Sort in decreasing order
        Integer[] arr = Arrays.stream(chunks).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        // List to store remaining capacity of each upload batch
        List<Integer> remainingCapacity = new ArrayList<>();

        for (int size : arr) {

            boolean placed = false;

            // Try to place chunk in existing uploads
            for (int i = 0; i < remainingCapacity.size(); i++) {
                if (remainingCapacity.get(i) >= size) {

                    // Reduce remaining capacity
                    remainingCapacity.set(i, remainingCapacity.get(i) - size);
                    placed = true;
                    break;
                }
            }

            // If not placed, create new upload batch
            if (!placed) {
                remainingCapacity.add(capacity - size);
            }
        }

        return remainingCapacity.size();
    }

    public static void main(String[] args) {
        int[] chunks = {4, 3, 3, 2, 2, 2};
        int capacity = 6;

        System.out.println("Minimum Uploads: " + minUploads(chunks, capacity));
    }
}
