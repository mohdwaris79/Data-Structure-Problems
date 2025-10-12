import java.util.*;

class Frequency {
    public static int[] frequencyCount(int arr[], int n) {
        int[] freq = new int[n];  
        
        for (int num : arr) {
            if (num >= 1 && num <= n) {
                freq[num - 1]++;   
            }
        }
        
        return freq;
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 3, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(frequencyCount(arr, n)));
            }
}
