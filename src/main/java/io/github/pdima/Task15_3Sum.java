package io.github.pdima;

import java.util.*;

public class Task15_3Sum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();

            for (int k = 0; k < nums.length; k++) {
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum == 0) {
                        result.add(List.of(nums[k], nums[i], nums[j]));
                        i++;
                        j--;
                    } else if (sum > 0) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }

            return new ArrayList<>(result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSum(new int[]{-3, -1, 1, 4, 3, -4, -2, 0, -1, 2, 0})); // [[-3, -1, 4], [-2, -1, 3], [-1, -1, 2], [-4, 1, 3], [-3, 1, 2], [-4, 0, 4], [-3, 0, 3], [-2, 0, 2], [-1, 0, 1]]
        System.out.println(solution.threeSum(new int[]{1, 2, -2, -1})); // []
    }

}
