package io.github.pdima;

public class Task733FloodFill {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] != color) {
                dfs(image, sr, sc, image[sr][sc], color);
            }

            return image;
        }

        private void dfs(int[][] image, int i, int j, int tagColor, int newColor) {
            if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != tagColor){
                return;
            }
            image[i][j] = newColor;

            dfs(image, i - 1, j, tagColor, newColor);
            dfs(image, i + 1, j, tagColor, newColor);
            dfs(image, i, j - 1, tagColor, newColor);
            dfs(image, i, j + 1, tagColor, newColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {
                {4, 0, 1, 2, 3},
                {2, 2, 2, 3, 2},
                {2, 1, 2, 2, 2}
        };

        Solution solution = new Solution();

        solution.floodFill(image, 1, 2, 8);
    }

}
