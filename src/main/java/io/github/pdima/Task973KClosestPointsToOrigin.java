package io.github.pdima;

import java.util.*;

public class Task973KClosestPointsToOrigin {

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            Queue<int[]> queue = new PriorityQueue<>(
                    Comparator.comparing(point -> Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2)))
            );

            for (int[] point: points) {
                queue.offer(point);
            }

            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll();
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 0}, {0, 1}}, 2))); // [[1, 0], [0, 1]]
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2))); // [[3, 3], [-2, 4]]
    }
}
