
    

import java.util.*;

public class Postfix {
    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "231*+9-";
        System.out.println("Result: " + evaluate(expr)); // Output: -4
    }
}
