package array;

import java.util.Arrays;

// Today I've learned that we need to pay extra attention on special cases that might cause a error, because they are usually hidden when we're compiling.
class No0907Solution {
    public static int[] sortedSquares(int[] src) {

        int n = src.length;
        int[] fnl = new int[n];
        for (int i = 0, j = n - 1, position = n - 1; i <= j; ) {
            // This will compensate the error while the array contain a negative number that the absolute number of the first number is bigger than the last number.
            // An alternative writing would be if( -src[i] > src[j]) {
            // Since the proceeding time is nearly equal, I wrote this easy-to-understand method.
            if (src[i] * src[i] > src[j] * src[j]) {
                fnl[position] = src[i] * src[i];
                ++i;
            } else { // When the last number is bigger than the absolute number of the first number.
                fnl[position] = src[j] * src[j];
                --j;
            }
            --position;
        }
        return fnl;
    }
}

public class No0907 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] src = {-9, -5, -4, -1, 0, 3, 10};
        int[] fnl = No0907Solution.sortedSquares(src);
        System.out.println(Arrays.toString(fnl));
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        System.out.println(runtime);
    }
}
