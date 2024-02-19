package io.github.pdima;

public class Task35SearchInsertPosition {

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int m = left + (right - left) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (target > nums[m]) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }

            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.searchInsert(new int[]{1, 2, 4, 6, 8, 10, 12, 15, 18}, 0)); // 0
        System.out.println(solution.searchInsert(new int[]{1, 2, 4, 6, 8, 10, 12, 15, 18}, 11)); // 6
        System.out.println(solution.searchInsert(new int[]{1, 2, 4, 6, 8, 10, 12, 15, 18}, 19)); // 9
        System.out.println(solution.searchInsert(new int[]{1, 2, 4, 6, 8, 10, 12, 15, 18}, 3)); // 2
    }
}
