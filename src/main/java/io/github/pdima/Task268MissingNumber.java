package io.github.pdima;

public class Task268MissingNumber {

    static class Solution {
        public int missingNumber(int[] nums) {
            int diff = 0;
            for (int i = 0; i < nums.length; i++) {
                diff = diff + nums[i] - i;
            }

            return nums.length - diff;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.missingNumber(new int[]{0, 1})); // 2
        System.out.println(solution.missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(solution.missingNumber(new int[]{5, 3, 1, 0, 4})); // 2
    }
}
