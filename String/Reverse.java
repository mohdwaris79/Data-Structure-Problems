class Reverse {
    public static void main(String[] args) {
        String str = "hello";

        // Using StringBuilder
        String reversed = new StringBuilder(str).reverse().toString();

        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reversed);
    }
}
