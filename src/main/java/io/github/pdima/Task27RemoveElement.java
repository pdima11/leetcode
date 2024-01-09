package io.github.pdima;

public class Task27RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
           int result = 0;
           for (int i = 0; i < nums.length; i++) {
               if (nums[i] != val) {
                   nums[result] = nums[i];
                   result++;
               }
           }

           return result;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2};
        int value = 4;

        Solution solution = new Solution();
        System.out.println(solution.removeElement(arr, value));
    }


}
