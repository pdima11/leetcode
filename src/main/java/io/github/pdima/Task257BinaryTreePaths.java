package io.github.pdima;

import java.util.ArrayList;
import java.util.List;

public class Task257BinaryTreePaths {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();

            findAllPaths(root, new StringBuilder(), result);

            return result;
        }

        private void findAllPaths(TreeNode node, StringBuilder path, List<String> result) {
            if (node == null) {
                return;
            }

            int len = path.length();
            if (len > 0) {
                path.append("->");
            }
            path.append(node.val);

            if (node.left == null && node.right == null) {
                result.add(path.toString());
            } else {
                findAllPaths(node.left, path, result);
                findAllPaths(node.right, path, result);
            }

            path.setLength(len);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solution.binaryTreePaths(root)); // ["1->2->4", "1->2->5", "1->3"]
    }
}
