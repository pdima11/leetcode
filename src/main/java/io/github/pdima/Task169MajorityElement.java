package io.github.pdima;

public class Task169MajorityElement {

    static class Solution {
        public int majorityElement(int[] nums) {
            int major = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == major) {
                    count++;
                } else if (count == 0) {
                    major = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }

            return major;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.majorityElement(new int[]{3, 1, 3})); // 3
        System.out.println(solution.majorityElement(new int[]{2, 3, 3, 2, 3, 4, 3, 2, 3})); // 3
        System.out.println(solution.majorityElement(new int[]{0, 1, 1, 0, 1, 1, 2})); // 1
    }
}
