package stackAndQueue;

class No1047Solution {
    public static String removeDuplicates(String src) {
        // Initialize
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < src.length(); ++i) {
            // Read every single word
            char ch = src.charAt(i);
            // If two word are same
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else { // If they are not same
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}


public class No1047 {
    public static void main(String[] args) {
        String src = "abbaca";
        String fnl = No1047Solution.removeDuplicates(src);
        System.out.println(fnl);
    }
}
