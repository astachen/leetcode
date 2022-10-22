package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

// Today I've learned that switch can be used to form a syntax system. This will be very useful comparing to multiple if when facing multiple tasks.
class No0150Solution {
    public static int evalRPN(String[] src) {
        // Initialize
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = src.length;
        for (int i = 0; i < n; i++) {
            String element = src[i];
            // If this is a number
            if (isNumber(element)) {
                // Push them into the stack, waiting for calculate
                stack.push(Integer.parseInt(element));
            } else {
                // Read the original numbers
                int num2 = stack.pop();
                int num1 = stack.pop();
                // Calculate them, and push the result to the stack
                switch (element) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String element) {
        // There are only 5 input: "+", "-", "*", "/", and numbers
        // \d can also achieve this
        return !("+".equals(element) || "-".equals(element) || "*".equals(element) || "/".equals(element));
    }
}


public class No0150 {
    public static void main(String[] args) {
        String[] src = {"2", "1", "+", "3", "*"};
        int fnl = No0150Solution.evalRPN(src);
        System.out.println(fnl);

    }
}
