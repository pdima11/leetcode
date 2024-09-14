package io.github.pdima;

import java.util.Arrays;

public class Task645SetMismatch {
    static class Solution {
//        public int[] findErrorNums(int[] nums) {
//            int[] counts = new int[nums.length + 1];
//            for (int num: nums) {
//                counts[num]++;
//            }
//
//            int[] result = new int[2];
//            for (int i = 1; i < counts.length; i++) {
//                if (counts[i] == 0) {
//                    result[1] = i;
//                }
//                if (counts[i] == 2) {
//                    result[0] = i;
//                }
//            }
//
//            return result;
//        }

        public int[] findErrorNums(int[] nums) {
            int[] result = new int[2];
            for (int num: nums) {
                int i = Math.abs(num);
                if (nums[i - 1] < 0) {
                    result[0] = i;
                } else {
                    nums[i - 1] *= -1;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result[1] = i + 1;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4}))); // [2, 3]
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 3, 3, 4}))); // [3, 2]
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{5, 7, 2, 1, 3, 4, 4}))); // [4, 6]
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1}))); // [1, 2]

        System.out.println(2 ^ 3);
    }
}
