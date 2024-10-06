package io.github.pdima;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task939MinimumAreaRectangle {
    static class Solution {
        public int minAreaRect(int[][] points) {
            Map<Integer, Set<Integer>> pointsMap = new HashMap<>();

            for (int[] point: points) {
                if (!pointsMap.containsKey(point[0])) {
                    pointsMap.put(point[0], new HashSet<Integer>());
                }
                pointsMap.get(point[0]).add(point[1]);
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < points.length - 1; i++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                for (int j = i + 1; j < points.length; j++) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    if (x1 != x2 && y1 != y2) {
                        if (pointsMap.get(x1).contains(y2) && pointsMap.get(x2).contains(y1)) {
                            result = Math.min(result, Math.abs((x1 - x2) * (y1 - y2)));
                        }
                    }
                }
            }

            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minAreaRect(
                new int[][]{
                        {1, 0}, {1, 1}, {1, 3}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {4, 2}, {4, 3}, {6, 0}, {6, 1}
                }
        )); // 1
    }
}
