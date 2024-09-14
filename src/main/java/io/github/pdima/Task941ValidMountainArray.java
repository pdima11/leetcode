package io.github.pdima;

public class Task941ValidMountainArray {

    static class Solution {
        public boolean validMountainArray(int[] arr) {
            int up = 0;
            int down = arr.length - 1;
            while (up < arr.length - 1 && arr[up] < arr[up + 1]) {
                up++;
            }
            while (down > 0 && arr[down] < arr[down - 1]) {
                down--;
            }

            return up > 0 && down < arr.length - 1 && up == down;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.validMountainArray(new int[]{2, 2, 3, 4, 2, 1})); // false
        System.out.println(solution.validMountainArray(new int[]{1, 2, 3, 4, 3, 2, 1})); // true
        System.out.println(solution.validMountainArray(new int[]{0, 0, 0, 0, 0})); // false
        System.out.println(solution.validMountainArray(new int[]{2, 4, 6, 7, 5, 3, 3, 1})); // false
        System.out.println(solution.validMountainArray(new int[]{2, 4, 6, 7})); // false
        System.out.println(solution.validMountainArray(new int[]{9, 5, 4, 3, 2})); // false
    }

}
