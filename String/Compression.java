public class Compression {
    // Method to compress string
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 1; 
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)); 
                sb.append(count);           // add frequency
                count = 1; // reset
            }
        }

        return sb.toString();
    }

   
    public static void main(String[] args) {
        String input = "aaabbcddd";
        String result = compress(input);

        System.out.println("Original: " + input);
        System.out.println("Compressed: " + result);
    }
}
