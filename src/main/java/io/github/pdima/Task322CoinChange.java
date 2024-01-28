package io.github.pdima;

import java.util.Arrays;

public class Task322CoinChange {

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] ways = new int[amount + 1];
            Arrays.fill(ways, Integer.MAX_VALUE);
            ways[0] = 0;

            for (int coin: coins) {
                for (int a = coin; a < ways.length; a++) {
                    if (ways[a - coin] != Integer.MAX_VALUE) {
                        ways[a] = Math.min(ways[a], ways[a - coin] + 1);
                    }
                }
            }

            return ways[amount] != Integer.MAX_VALUE ? ways[amount] : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(solution.coinChange(new int[]{1, 3, 4}, 6)); // 2
        System.out.println(solution.coinChange(new int[]{2, 4}, 7)); // -1
    }

}
