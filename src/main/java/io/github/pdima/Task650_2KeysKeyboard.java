package io.github.pdima;

public class Task650_2KeysKeyboard {

    static class Solution {
        public int minSteps(int n) {
            int result = 0;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    n = n / i;
                    result += i;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(2)); // 2
        System.out.println(solution.minSteps(3)); // 3
        System.out.println(solution.minSteps(9)); // 6
        System.out.println(solution.minSteps(18)); // 8
    }
}
