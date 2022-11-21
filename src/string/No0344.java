package string;

import java.util.Arrays;

// This question requires O(1) spaces to achieve it. Thus I use double pivots.
class No0344Solution {
    public static String[] reverseString(String[] src) {
        int n = src.length;
        // Swap the first and last, and tighten two pivots.
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            String tmp = src[left];
            src[left] = src[right];
            src[right] = tmp;
        }
        return src;
    }
}

public class No0344 {
    public static void main(String[] args) {
        String[] src = {"h","e","l","l","o"};
        String[] fnl = No0344Solution.reverseString(src);
        System.out.println(Arrays.toString(fnl));
    }

}
