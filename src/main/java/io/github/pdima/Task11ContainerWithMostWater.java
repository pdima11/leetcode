package io.github.pdima;

public class Task11ContainerWithMostWater {

    static class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int result = 0;
            while (i < j) {
                int h = Math.min(height[i], height[j]);
                result = Math.max(result, (j - i) * h);

                while (i < j && height[i] <= h) {
                    i++;
                }
                while (i < j && height[j] <= h) {
                    j--;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] {3, 7, 6, 3, 2})); // 9
        System.out.println(solution.maxArea(new int[] {2, 4, 3, 5, 1})); // 8
    }
}
