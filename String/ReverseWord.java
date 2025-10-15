class ReverseWord {
    public String reverseWords(String s) {
       
        s = s.trim();
       
        String[] words = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" "); // add space between words
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
      ReverseWord sol = new ReverseWord();

        String s1 = "the sky is blue";
        String s2 = "  hello   world  ";
        String s3 = "a good   example";

        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s1) + "\"");

        System.out.println("\nInput: \"" + s2 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s2) + "\"");

        System.out.println("\nInput: \"" + s3 + "\"");
        System.out.println("Output: \"" + sol.reverseWords(s3) + "\"");
    }
}
