public class LargestNumberOneSwap {
    public static String largestString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        
        int[] last = new int[256];
        for (int i = 0; i < n; i++) {
            last[arr[i]] = i;
        }

      
        for (int i = 0; i < n; i++) {
            for (int c = 255; c > arr[i]; c--) {
                if (last[c] > i) {
                    // swap
                    char temp = arr[i];
                    arr[i] = arr[last[c]];
                    arr[last[c]] = temp;
                    return new String(arr);
                }
            }
        }

        return s; 
    }

    public static void main(String[] args) {
        System.out.println(largestString("768"));  // 867
        System.out.println(largestString("333"));  // 333
        System.out.println(largestString("5291")); // 9512
    }
}
