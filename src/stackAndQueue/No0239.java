package stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// Today I've learned that sometimes we need to separate the first process to prevent the error that might happen during the test.
class Solution {
    public static int[] maxSlidingWindow(int[] src, int range) {
        // Initialize
        int n = src.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        // push all the value that is greater than the element on the left of it in the first window
        for (int i = 0; i < range; ++i) {
            while (!deque.isEmpty() && src[i] >= src[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - range + 1];
        ans[0] = src[deque.peekFirst()];
        //  the rest of the windows
        for (int i = range; i < n; ++i) {
            while (!deque.isEmpty() && src[i] >= src[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - range) {
                deque.pollFirst();
            }
            ans[i - range + 1] = src[deque.peekFirst()];
        }
        return ans;
    }
}



public class No0239 {
    public static void main(String[] args) {
        int[] src = {1,3,-1,-3,5,3,6,7};
        int range = 3;
        System.out.println(Arrays.toString(Solution.maxSlidingWindow(src,range)));
    }
}
