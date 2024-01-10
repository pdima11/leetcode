package io.github.pdima;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> diffs = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (diffs.containsKey(nums[i])) {
                    return new int[]{diffs.get(nums[i]), i};
                } else {
                    int diff = target - nums[i];
                    diffs.put(diff, i);
                }
            }

            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert Arrays.equals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        assert Arrays.equals(solution.twoSum(new int[]{1, 7, 4, 11}, 12), new int[]{0, 3});
        assert Arrays.equals(solution.twoSum(new int[]{2, 7, 9, 15, 1}, 8), new int[]{1, 4});
        assert Arrays.equals(solution.twoSum(new int[]{0, 3, 1, 5}, 1), new int[]{0, 2});

        System.out.println("OK");
    }

}
