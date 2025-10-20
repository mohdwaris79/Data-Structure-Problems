import java.util.HashMap;
import java.util.Scanner;

public class FrequencyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Use HashMap to store frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

       
        System.out.println("Frequency of elements:");
        for (int key : freqMap.keySet()) {
            System.out.println(key + " occurs " + freqMap.get(key) + " times");
        }

        sc.close();
    }
}
