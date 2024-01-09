package io.github.pdima;

public class Task278FirstBadVersion {

    static class VersionControl {
        protected boolean isBadVersion(int n) {
            return n >= 4;
        }
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int start = 0;
            int end = n;
            while (end - start > 1) {
                int m = start + (end - start) / 2;
                if (isBadVersion(m)) {
                    end = m;
                } else {
                    start = m;
                }
            }

            return end;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.firstBadVersion(solution.firstBadVersion(10)));
    }

}
