import java.util.*;

class ReverseWord {
    public String reverseWords(String s) {
        // Split by dot
        String[] parts = s.split("\\.");
        List<String> words = new ArrayList<>();

        for (String word : parts) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        // Reverse the list
        Collections.reverse(words);

        return String.join(".", words);
    }

    public static void main(String[] args) {
       ReverseWord sol = new ReverseWord();
        String s = "i.like..this.programming.very.much";
        System.out.println(sol.reverseWords(s));

    }
}
