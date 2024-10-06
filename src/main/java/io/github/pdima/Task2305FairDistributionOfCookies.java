package io.github.pdima;

public class Task2305FairDistributionOfCookies {
    static class Solution {
        private int result = Integer.MAX_VALUE;

        public int distributeCookies(int[] cookies, int k) {
            int[] childrenCookiesCounts = new int[k];

            backtrack(0, cookies, childrenCookiesCounts);

            return result;
        }

        private void backtrack(int index, int[] cookies, int[] childrenCookiesCounts) {
            if (index >= cookies.length) {
                int maxCount = 0;
                for (int count : childrenCookiesCounts) {
                    maxCount = Math.max(maxCount, count);
                }
                result = Math.min(result, maxCount);

                return;
            }

            for (int i = 0; i < childrenCookiesCounts.length; i++) {
                if (childrenCookiesCounts[i] + cookies[index] >= result ||
                        (i > 0 && childrenCookiesCounts[i] == childrenCookiesCounts[i - 1])) {
                    continue;
                }

                childrenCookiesCounts[i] += cookies[index];
                backtrack(index + 1, cookies, childrenCookiesCounts);
                childrenCookiesCounts[i] -= cookies[index];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.distributeCookies(new int[]{8, 15, 10, 20, 8}, 2)); // 31
    }
}
