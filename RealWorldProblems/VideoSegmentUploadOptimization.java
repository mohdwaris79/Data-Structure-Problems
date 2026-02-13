import java.util.Arrays;

public class VideoSegmentUploadOptimization {

    public static int minUploads(int[] chunks, int capacity) {

        // Step 1: Sort the chunks
        Arrays.sort(chunks);

        int left = 0;                     // Smallest chunk
        int right = chunks.length - 1;    // Largest chunk
        int uploads = 0;                  // Result counter

        // Step 2: Two pointer Approach
        while (left <= right) {

            // If smallest + largest fits in one upload
            if (chunks[left] + chunks[right] <= capacity) {
                left++;    // Move smallest pointer
            }

            // Largest chunk is always processed
            right--;

            // One upload used
            uploads++;
        }

        return uploads;
    }

    
    public static void main(String[] args) {
        int[] chunks = {4, 8, 1, 2, 5};
        int capacity = 10;

        System.out.println("Minimum Uploads: " + minUploads(chunks, capacity));
    }
}
