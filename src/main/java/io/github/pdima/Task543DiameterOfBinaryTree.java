package io.github.pdima;

public class Task543DiameterOfBinaryTree {

    private static class TreeNode {
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

        private class Result {
            int value;

            public Result(int value) {
                this.value = value;
            }
        }

        public int diameterOfBinaryTree(TreeNode root) {
            Result maxDiameter = new Result(0);
            evaluateDiameter(root, maxDiameter);

            return maxDiameter.value;
        }

        private int evaluateDiameter(TreeNode node, Result max) {
            if (node == null) {
                return -1;
            }

            int leftDiameter = evaluateDiameter(node.left, max) + 1;
            int rightDiameter = evaluateDiameter(node.right, max) + 1;

            max.value = Math.max(leftDiameter + rightDiameter, max.value);

            return Math.max(leftDiameter, rightDiameter);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println(solution.diameterOfBinaryTree(root)); // 4
    }

}
