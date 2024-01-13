package io.github.pdima;

public class Task110BalancedBinaryTree {

    public static class TreeNode {
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
        public boolean isBalanced(TreeNode root) {
            return calcHeight(root) != -1;
        }

        private int calcHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = calcHeight(root.left);
            int rightHeight = calcHeight(root.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(solution.isBalanced(root));

        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println(solution.isBalanced(root));
    }

}
