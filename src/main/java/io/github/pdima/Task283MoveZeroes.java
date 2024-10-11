package io.github.pdima;

import java.util.Arrays;

public class Task283MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0;
            int fast = 1;
            while (fast < nums.length) {
                if (nums[slow] == 0 && nums[fast] != 0) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                if (nums[slow] != 0) {
                    slow++;
                }
                fast++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{0, 1, 0, 4, 5};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [1, 4, 5, 0, 0]

        arr = new int[]{0};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [0]

        arr = new int[]{1};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [1]

        arr = new int[]{0, 1, 1, 1, 0};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [1, 1, 1, 0, 0]
    }
}
