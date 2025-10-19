import java.util.*;

class RomanToInteger {
    public static int romanToInt(String s) {
        // Map of Roman numerals
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));

            // If the next value is bigger, subtract
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("XIV = " + romanToInt("XIV"));   // 14
        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV")); // 1994
        System.out.println("LVIII = " + romanToInt("LVIII")); // 58
    }
}
