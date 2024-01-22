package io.github.pdima;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task542_01Matrix {

    static class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];

                if (y - 1 >= 0 && mat[x][y - 1] == -1) {
                    mat[x][y - 1] = mat[x][y] + 1;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y + 1 < mat[0].length && mat[x][y + 1] == -1) {
                    mat[x][y + 1] = mat[x][y] + 1;
                    queue.offer(new int[]{x, y + 1});
                }
                if (x - 1 >= 0 && mat[x - 1][y] == -1) {
                    mat[x - 1][y] = mat[x][y] + 1;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x + 1 < mat.length && mat[x + 1][y] == -1) {
                    mat[x + 1][y] = mat[x][y] + 1;
                    queue.offer(new int[]{x + 1, y});
                }
            }

            return mat;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix)));
    }

}
