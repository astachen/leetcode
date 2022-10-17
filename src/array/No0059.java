package array;

import java.util.Arrays;

class Solution {
    public static int[][] generateMatrixExample(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    // Today I've learned that it is better to divide 1 question to multiple process.
    public static int[][] generateMatrix(int n) {
        // Initialize the steps of each direction.
        int upStep = 0, downStep = n - 1, rightStep = 0, leftStep = n - 1;
        int[][] mat = new int[n][n];
        int startStep = 1, fnlStep = n * n;
        // There are empty places in the matrix
        while (startStep <= fnlStep) {
            // Fill the matrix from right to left.
            for (int i = upStep; i <= downStep; i++) {
                mat[rightStep][i] = startStep++;
            }
            rightStep++;

            // Fill the matrix from top to bottom
            for (int i = rightStep; i <= leftStep; i++) {
                mat[i][downStep] = startStep++;
            }
            downStep--;
            // Fill the matrix from Right to Left
            for (int i = downStep; i >= upStep; i--) {
                mat[leftStep][i] = startStep++;
            }
            leftStep--;

            // Fill the matrix from Bottom to Top
            for (int i = leftStep; i >= rightStep; i--) {
                mat[i][upStep] = startStep++;
            }
            upStep++;

        }
        return mat;
    }
}

public class No0059 {
    public static void main(String[] args) {
        int src = 3;
        int[][] fnl = Solution.generateMatrixExample(src);
        int[][] selfFnl = Solution.generateMatrix(src);
        System.out.println(Arrays.deepToString(fnl));
        System.out.println(Arrays.deepToString(selfFnl));
    }
}
