package io.github.pdima;

import java.util.ArrayList;
import java.util.List;

public class Task207CourseSchedule {

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] colors = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
                colors[i] = 1;
            }

            for (int[] prerequisite: prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (colors[i] == 1 && containsCycle(i, graph, colors)) {
                    return false;
                }
            }

            return true;
        }

        private boolean containsCycle(int vertex, List<List<Integer>> graph, int[] colors) {
            colors[vertex] = 2;
            for (int nextVertex: graph.get(vertex)) {
                if (colors[nextVertex] == 2) {
                    return true;
                }
                if (colors[nextVertex] == 3) {
                    continue;
                }

                if (containsCycle(nextVertex, graph, colors)) {
                    return true;
                }
            }
            colors[vertex] = 3;

            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canFinish(4, new int[][]{{2, 1}, {3, 2}, {1, 0}})); // true
        System.out.println(solution.canFinish(2, new int[][]{{0, 1}, {1, 0}})); // false
    }

}
