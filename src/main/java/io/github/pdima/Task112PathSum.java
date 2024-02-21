package io.github.pdima;

public class Task112PathSum {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null && targetSum - root.val == 0) {
                return true;
            }

            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        System.out.println(solution.hasPathSum(root, 22)); // true
        System.out.println(solution.hasPathSum(root, 27)); // false
        System.out.println(solution.hasPathSum(null, 0)); // false
    }

}
