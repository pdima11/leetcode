package io.github.pdima;

import com.sun.source.tree.Tree;

public class Task226InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode temp = invertTree(root.left);
                root.left = invertTree(root.right);
                root.right = temp;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = solution.invertTree(root);

        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right);
    }

}
