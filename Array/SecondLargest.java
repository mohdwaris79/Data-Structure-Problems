import java.util.Arrays;

public class SecondLargest {
    public static int secondLargest(int[] arr) {
        Arrays.sort(arr); // ascending order

        int n = arr.length;
        int largest = arr[n - 1];

        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                return arr[i];
            }
        }

        throw new IllegalArgumentException("All elements are the same, no second largest");
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 6, 8, 9, 10, 15, 7};
        System.out.println("Second largest: " + secondLargest(arr));
    }
}
