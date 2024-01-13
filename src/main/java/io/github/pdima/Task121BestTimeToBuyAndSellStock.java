package io.github.pdima;

public class Task121BestTimeToBuyAndSellStock {

    static class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;

            int i = 0, j = 0;
            while (i < prices.length) {
                int profit = prices[i] - prices[j];
                if (profit > 0) {
                    result = Math.max(result, profit);
                } else {
                    j = i;
                }
                i++;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 2, 5, 1, 6, 4, 8, 5}));
    }
}
