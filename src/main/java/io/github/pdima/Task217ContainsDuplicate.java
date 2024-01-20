package io.github.pdima;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task217ContainsDuplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> numbers = new HashSet<>();

            for (int num: nums) {
                if (numbers.contains(num)) {
                    return true;
                } else {
                    numbers.add(num);
                }
            }

            return false;
        }

        public boolean containsDuplicate2(int[] nums) {
            Arrays.sort(nums);

            int current  = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (current == nums[i]) {
                    return true;
                }
                current = nums[i];
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.containsDuplicate(new int[]{1})); // false
        System.out.println(solution.containsDuplicate2(new int[]{1})); // false

        System.out.println(solution.containsDuplicate(new int[]{1, 4, 5, 3, 1})); // true
        System.out.println(solution.containsDuplicate2(new int[]{1, 4, 5, 3, 1})); // true

        System.out.println(solution.containsDuplicate(new int[]{1, 2, 5, 4, 5, 3})); // true
        System.out.println(solution.containsDuplicate2(new int[]{1, 2, 5, 4, 5, 3})); // true

        System.out.println(solution.containsDuplicate(new int[]{1, 2, 5, 4, 0, 3, 7, 3})); // true
        System.out.println(solution.containsDuplicate2(new int[]{1, 2, 5, 4, 0, 3, 7, 3})); // true
    }
}
