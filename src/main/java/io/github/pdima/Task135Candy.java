package io.github.pdima;

import java.util.Arrays;

public class Task135Candy {
    static class Solution {
        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);

            for (int i = 0; i < candies.length - 1; i++) {
                if (ratings[i + 1] > ratings[i]) {
                    candies[i + 1] = candies[i] + 1;
                }
            }

            for (int i = candies.length - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                    candies[i - 1] = candies[i] + 1;
                }
            }

            int result = 0;
            for (int candy : candies) {
                result += candy;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.candy(new int[]{1,  0, 2})); // 5
        System.out.println(solution.candy(new int[]{2, 1, 1})); // 4
        System.out.println(solution.candy(new int[]{1, 2, 4, 4, 4, 2, 1})); // 13
    }
}
