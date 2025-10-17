class Duplicate {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII characters

        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                sb.append(ch);
                seen[ch] = true;
            }
        }

        System.out.println("After removing duplicates: " + sb.toString());
    }
}
