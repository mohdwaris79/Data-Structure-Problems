
public class Equilibrium {

    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int totalSum = 0;

        for (int num : arr)
            totalSum += num;

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum)
                return i;  

            leftSum += arr[i];
        }

        return -1; 
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 2};
        int result = findEquilibrium(arr);

        if (result != -1)
            System.out.println("Equilibrium index: " + result);
        else
            System.out.println("No equilibrium point found");
    }
}
