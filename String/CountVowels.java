

class CountVowels {
    public static void main(String[] args) {
        String str = "apple".toLowerCase();
        int vowels = 0, consonants = 0;

        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
