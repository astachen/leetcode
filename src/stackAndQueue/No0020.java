package stackAndQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Today I've learned that we need to utilize all the advantages of the tools, if necessary create one by using the basic rule of the tool.
class No0020Solution {
    // Since this question can be simplified as the match of two brackets, we can use stack to do this.
    public static boolean isValidStack(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // Initializing stack
        Deque<Character> stack = new LinkedList<Character>();
        // Matching
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        // If two brackets can't match (for example (] )this will return false.
        return stack.isEmpty();
    }
}


public class No0020 {
    public static void main(String[] args) {
        String src = "([)";
        boolean fnl = No0020Solution.isValidStack(src);
        System.out.println(fnl);
    }


}
