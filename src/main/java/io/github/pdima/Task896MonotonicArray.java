package io.github.pdima;

public class Task896MonotonicArray {
    static class Solution {
        public boolean isMonotonic(int[] nums) {
            if (nums[0] > nums[nums.length - 1]) {
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] < nums[i + 1]) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isMonotonic(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(solution.isMonotonic(new int[]{1, 1, 1, 1, 1,})); // true
        System.out.println(solution.isMonotonic(new int[]{1, 2, 3, 1})); // false
        System.out.println(solution.isMonotonic(new int[]{4, 4, 3, 3, 2, 1})); // true
        System.out.println(solution.isMonotonic(new int[]{6, 6, 5, 5, 3, 4})); // false
    }

}
