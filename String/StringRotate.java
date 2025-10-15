class StringRotate {
    public static boolean isRotated(String s1, String s2) {
        // lengths must be equal
        if (s1.length() != s2.length()) return false;
        
        // concatenate s1 with itself
        String doubled = s1 + s1;
        
        // check if s2 is a substring of doubled string
        return doubled.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "azonam";
        System.out.println(isRotated(s1, s2)); // true

        String s3 = "hello";
        String s4 = "lohel";
        System.out.println(isRotated(s3, s4)); // true

        String s5 = "abc";
        String s6 = "bac";
        System.out.println(isRotated(s5, s6)); // false
    }
}
