package io.github.pdima;

public class Task209MinimumSizeSubarraySum {

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = 0;
            int sum = 0;
            int min = 0;

            int i = 0, j = 0;
            while (i < nums.length || sum >= target) {
                if (sum < target) {
                    sum += nums[i];
                    min += 1;
                    i++;
                } else {
                    if ((min < result || result == 0) && sum >= target) {
                        result = min;
                    }
                    sum -= nums[j];
                    min -= 1;
                    j++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2;
        assert solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0;
    }
}
