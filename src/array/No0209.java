package array;

// Today I've learned that properly using the aspects of the question and the answer can help you to save a lot of time.
class No0209Solution {
    public static int MinSubArrayLenDPivot(int target, int[] src) {
        // Initialize the fast pivot and the slow pivot
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < src.length) {
            // Add new element
            sum += src[end++];
            // If the sum is bigger than target
            while (sum >= target) {
                // Compare the new acceptable sub array and the previous
                minLen = Math.min(minLen, end - start);
                // delete the first element of the sub array
                sum -= src[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

public class No0209 {
    public static void main(String[] args) {
        int[] src = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(No0209Solution.MinSubArrayLenDPivot(target, src));
    }

}
