package io.github.pdima;


public class Task101SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            return areNodesEqual(root.left, root.right);
        }

        private boolean areNodesEqual(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            return areNodesEqual(node1.left, node2.right) && areNodesEqual(node1.right, node2.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root)); // true

        root.left.left.left = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        System.out.println(solution.isSymmetric(root)); // false
    }


}
