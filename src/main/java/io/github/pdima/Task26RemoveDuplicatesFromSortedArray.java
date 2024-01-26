package io.github.pdima;

import java.util.Arrays;

public class Task26RemoveDuplicatesFromSortedArray {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 1;
            int num = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != num) {
                    nums[count] = nums[i];
                    num = nums[i];
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = new int[]{0, 1, 1, 1, 3, 4, 5, 5};
        System.out.println(solution.removeDuplicates(array) + " - " + Arrays.toString(array)); // 5 - [0, 1, 3, 4, 5, ...]

        int[] array2 = new int[]{0, 0, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 7};
        System.out.println(solution.removeDuplicates(array2) + " - " + Arrays.toString(array2)); // 7 - [0, 1, 2, 3, 4, 5, 7, ...]
    }

}
