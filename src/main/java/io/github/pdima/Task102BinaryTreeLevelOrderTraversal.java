package io.github.pdima;

import java.util.ArrayList;
import java.util.List;

public class Task102BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            collectNodesToList(root, result, 0);

            return result;
        }

        private void collectNodesToList(TreeNode node, List<List<Integer>> list, int level) {
            if (node == null) {
                return;
            }

            if (list.size() < level + 1) {
                list.add(new ArrayList<>(List.of(node.val)));
            } else {
                list.get(level).add(node.val);
            }

            collectNodesToList(node.left, list, level + 1);
            collectNodesToList(node.right, list, level + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(solution.levelOrder(root)); // [[1], [2, 3], [4, 5], [6, 7, 8]]
    }

}
