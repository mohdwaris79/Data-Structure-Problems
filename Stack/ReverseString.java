import java.util.*;

class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Reversed String: " + reversed);
    }
}
