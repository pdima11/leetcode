package io.github.pdima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task57InsertInterval {

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> results = new ArrayList<>();

            for (int[] interval: intervals) {
                if (interval[1] < newInterval[0]) {
                    results.add(interval);
                } else if (interval[0] > newInterval[1]) {
                    results.add(newInterval);
                    newInterval = interval;
                } else {
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                }
            }
            results.add(newInterval);

            return results.toArray(new int[0][0]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 5}}, new int[]{0, 3})));
    }
}
