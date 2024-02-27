package io.github.pdima;

import java.util.HashMap;
import java.util.Map;

public class Task219ContainsDuplicate2 {

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> items = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (items.containsKey(nums[i])) {
                    int j = items.get(nums[i]);
                    if (Math.abs(j - i) <= k) {
                        return true;
                    }
                }
                items.put(nums[i], i);
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
    }
}
