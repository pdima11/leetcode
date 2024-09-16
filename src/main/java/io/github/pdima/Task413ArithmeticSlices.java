package io.github.pdima;

public class Task413ArithmeticSlices {
    static class Solution {
//        public int numberOfArithmeticSlices(int[] nums) {
//            if (nums.length == 1) {
//                return 0;
//            }
//
//            int[] results = new int[nums.length];
//            results[0] = 0;
//            results[1] = 0;
//            for (int i = 1; i < nums.length - 1; i++) {
//                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
//                    results[i + 1] = results[i] + 1;
//                }
//            }
//
//            int result = 0;
//            for (int i = 0; i < results.length; i++) {
//                result += results[i];
//            }
//
//            return result;
//        }
        public int numberOfArithmeticSlices(int[] nums) {
            int result = 0;
            int prevResult = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    prevResult += 1;
                    result += prevResult;
                } else {
                    prevResult = 0;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 5, 7, 9})); // 4
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1})); // 0
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2})); // 0
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 7, 4, 7, 3})); // 0
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 7, 7, 7, 10, 7})); // 1
    }
}
