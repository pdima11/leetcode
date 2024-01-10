package io.github.pdima;

public class Task704BinarySearch {
    static class Solution {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{1, 3, 6, 7, 9, 10, 11}, 3)); //1
        System.out.println(solution.search(new int[]{2}, 2)); //0
        System.out.println(solution.search(new int[]{2, 7}, 7)); //1
        System.out.println(solution.search(new int[]{2, 5, 6, 7}, 3)); //-1
        System.out.println(solution.search(new int[]{}, 3)); //-1
    }
}
