package array;

// Today I've learned that comparing using two pivots, using one pivot will change the original data.
// Also, when you find an infinite loop, try to change a variable that hasn't changed before.
class No0027SolutionSingle {
    // Run this will cause an infinite loop.
    public static int[] MoveTarget(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] != target) {
                ++i;
                continue;
            }
            int temp = nums[i];
            for (int j = i; j < n - 1; ++j) {
                nums[j] = nums[j + 1];
            }
            nums[n - 1] = temp;


        }
        return nums;
    }

    // This can successfully run.
    public static int moveNotTarget(int[] nums, int target) {
        int pivot = 0;
        for (int x : nums) {
            if (x != target) {
                nums[pivot++] = x;
            }
        }
        return pivot;
    }

}


public class No0027 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        System.out.println((No0027SolutionSingle.moveNotTarget(nums, target)));
    }

}
