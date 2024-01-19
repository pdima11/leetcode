package io.github.pdima;

public class Task53MaximumSubarray {

    static class Solution {
        public int maxSubArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            }

            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }

            return max;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(solution.maxSubArray(new int[]{1})); // 1
        System.out.println(solution.maxSubArray(new int[]{1, 2, 3, 4, -9, 5, 3, 3, -4, -2, 1})); // 12
    }

}
