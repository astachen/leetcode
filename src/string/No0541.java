package string;

// This question requires the following operation:
// 1. Cut the string to two parts:the length of the first part is equal to "gap".
// 2. Reverse the first part.
// 3. Cut rest of the string to two parts: the length of the first part is equal to "gap".
// 4. Skip the first part.
// 5. Back to 1 until no string left.
class No0541Solution {
    public static String reverseStr(String src, int gap) {
        int n = src.length();
        // Breakdown the string to reverse it
        char[] arr = src.toCharArray();
        // Every time i increases 2 gap. This is step 5.
        for (int i = 0; i < n; i += 2 * gap) {
            reverse(arr, i, Math.min(i + gap, n) - 1);
        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}


public class No0541 {
    public static void main(String[] args) {
        String src = "abcdefg";
        int gap = 2;
        String fnl = No0541Solution.reverseStr(src, gap);
        System.out.println(fnl);
    }

}
