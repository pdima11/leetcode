package io.github.pdima;

import java.util.ArrayList;
import java.util.List;

public class Task366FindLeavesOfBinaryTree {

    static public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            dfs(root, result);

            return result;
        }

        private int dfs(TreeNode node, List<List<Integer>> result) {
            if (node == null) {
                return -1;
            }

            int height = Math.max(dfs(node.left, result), dfs(node.right, result)) + 1;

            while (result.size() <= height) {
                result.add(new ArrayList<>());
            }
            result.get(height).add(node.val);

            return height;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println(solution.findLeaves(root)); // [[4, 6, 7, 3], [5], [2], [1]]
    }

}
