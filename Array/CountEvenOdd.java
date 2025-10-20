import java.util.Scanner;

public class CountEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int evenCount = 0;
        int oddCount = 0;

        // Count even and odd
        for(int num : arr) {
            if(num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        
        System.out.println("Number of Even elements: " + evenCount);
        System.out.println("Number of Odd elements: " + oddCount);
        
        sc.close();
    }
}
