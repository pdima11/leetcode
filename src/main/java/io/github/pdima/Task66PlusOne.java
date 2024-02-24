package io.github.pdima;

import java.util.Arrays;

public class Task66PlusOne {
    static class Solution {
        public int[] plusOne(int[] digits) {
            int rest = -1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }

            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0] = 1;

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.plusOne(new int[]{2, 7, 8}))); // [2, 7, 9]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9}))); // [1, 0, 0, 0]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{2, 9, 9}))); // [3, 0, 0]
    }
}
