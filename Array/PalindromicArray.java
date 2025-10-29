
public class PalindromicArray {
    public static boolean isPalindrome(int n) {
        int rev = 0, temp = n;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev == temp;
    }

    public static boolean palinArray(int[] arr) {
        for (int num : arr) {
            if (!isPalindrome(num))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444, 555};
        System.out.println(palinArray(arr)); // true
    }
}
