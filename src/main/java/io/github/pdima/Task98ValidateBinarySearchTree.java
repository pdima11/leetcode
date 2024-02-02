package io.github.pdima;

public class Task98ValidateBinarySearchTree {
     static class TreeNode {
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
        public boolean isValidBST(TreeNode root) {
            return isNodeValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isNodeValid(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }

            return isNodeValid(node.left, min, node.val) && isNodeValid(node.right, node.val, max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        System.out.println(solution.isValidBST(root)); // false
    }
}
