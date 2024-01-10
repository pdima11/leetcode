package io.github.pdima;

import java.util.Arrays;

public class Task88MergeSortedArray {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (j >= 0) {
                if (i >= 0 && nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[]{0};
        solution.merge(nums1 , 0, new int[]{1}, 1);
        assert Arrays.equals(nums1, new int[]{1});

        int[] nums2 = new int[]{1};
        solution.merge(nums2 , 1, new int[]{}, 0);
        assert Arrays.equals(nums2, new int[]{1});

        int[] nums3 = new int[]{4, 0, 0, 0, 0, 0};
        solution.merge(nums3 , 1, new int[]{1, 2, 3, 5, 6}, 5);
        assert Arrays.equals(nums3, new int[]{1, 2, 3, 4, 5, 6});

        int[] nums4 = new int[]{1, 2, 3, 5, 7, 0, 0, 0, 0};
        solution.merge(nums4 , 5, new int[]{2, 4, 5, 9}, 4);
        assert Arrays.equals(nums4, new int[]{1, 2, 2, 3, 4, 5, 5, 7, 9});

        int[] nums5 = new int[]{4, 5, 6, 0, 0, 0};
        solution.merge(nums5 , 3, new int[]{1, 2, 3}, 3);
        assert Arrays.equals(nums5, new int[]{1, 2, 3, 4, 5, 6});

        System.out.println("OK");
    }

}
