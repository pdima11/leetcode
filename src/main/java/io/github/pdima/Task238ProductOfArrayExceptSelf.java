package io.github.pdima;

import java.util.Arrays;

public class Task238ProductOfArrayExceptSelf {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            int p = 1;
            for (int i = 0; i < nums.length; i++) {
                result[i] = p;
                p *= nums[i];
            }

            p = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] *= p;
                p *= nums[i];
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4}))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, -1, 1, 2}))); // [-2, -2, 2, 1]
    }
}
