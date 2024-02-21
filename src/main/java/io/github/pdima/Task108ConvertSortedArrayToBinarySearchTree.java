package io.github.pdima;

public class Task108ConvertSortedArrayToBinarySearchTree {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTreeFromArray(nums, 0, nums.length - 1);
        }

        private TreeNode buildTreeFromArray(int[] arr, int start, int end) {
            if (end < start) {
                return null;
            }
            int m = start + (end - start) / 2;

            TreeNode node = new TreeNode(arr[m]);

            node.left = buildTreeFromArray(arr, start, m - 1);
            node.right = buildTreeFromArray(arr, m + 1, end);

            return node;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root.val); // 0
        System.out.println(root.left.val); // -10
        System.out.println(root.right.val); // -5
        System.out.println(root.left.left); //  null
        System.out.println(root.left.right.val); // -3
        System.out.println(root.right.left); //  null
        System.out.println(root.right.right.val); // 9

    }
}
