package io.github.pdima;

import java.util.HashMap;
import java.util.Map;

public class Task70ClimbingStairs {

    static class Solution {

        public int climbStairs(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }

        public int climbStairs2(int n) {
            return calculateNumberOfOptions(n, new HashMap<>());
        }

        private int calculateNumberOfOptions(int n, Map<Integer, Integer> cache) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            if (n == 0) {
                return 1;
            }

            if (n < 0) {
                return 0;
            }

            int result = calculateNumberOfOptions(n - 1, cache) + calculateNumberOfOptions(n - 2, cache);
            cache.put(n, result);

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs2(1));

        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs2(5));

        System.out.println(solution.climbStairs(10));
        System.out.println(solution.climbStairs2(10));
    }



}
