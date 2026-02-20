public class Ranking {

    // Method returns top 3 numbers as an array
    public static int[] topThree(int arr[]) {
        if (arr.length < 3) {
            return new int[]{-1, -1, -1}; // Not enough elements
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest && num != secondLargest && num != largest) {
                thirdLargest = num;
            }
        }

        return new int[]{largest, secondLargest, thirdLargest};
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 20, 20, 8, 12};

        int top3[] = topThree(arr);

        System.out.println("Top 3 numbers:");
        for (int n : top3) {
            System.out.println(n);
        }
    }
}