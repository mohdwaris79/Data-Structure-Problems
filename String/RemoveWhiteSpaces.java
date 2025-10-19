class RemoveWhiteSpaces {
    public static void main(String[] args) {
        String str = "a b   c d e ";

       
        String result1 = str.replaceAll("\\s+", ""); 
        System.out.println("Using replaceAll: " + result1);

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch != ' ') {  // skip spaces
                sb.append(ch);
            }
        }
        String result2 = sb.toString();
        System.out.println("Using loop: " + result2);
    }
}
