class RotationCheck {
   
    public static boolean isRotation(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        // Concatenate s1 with itself
        String temp = s1 + s1;

        
        return temp.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        if (isRotation(s1, s2)) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is NOT a rotation of " + s1);
        }
    }
}
