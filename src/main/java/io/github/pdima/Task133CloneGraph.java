package io.github.pdima;

import java.util.*;

public class Task133CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            Map<Node, Node> clones = new HashMap<>();

            queue.offer(node);
            clones.put(node, new Node(node.val));

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Node neighbor: current.neighbors) {
                    if (!clones.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        clones.put(neighbor, new Node(neighbor.val));
                    }
                    clones.get(current).neighbors.add(clones.get(neighbor));
                }
            }

            return clones.get(node);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);

        Node result = solution.cloneGraph(node1);

        System.out.println(result != node1 && result.val == node1.val);
    }

}
