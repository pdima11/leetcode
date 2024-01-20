package io.github.pdima;

public class Task844BackspaceStringCompare {

    static class Solution {
        private String buildStringResult(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '#' && !sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (str.charAt(i) != '#') {
                    sb.append(str.charAt(i));
                }
            }

            return sb.toString();
        }

        public boolean backspaceCompare2(String s, String t) {
            return buildStringResult(s).equals(buildStringResult(t));
        }

        public boolean backspaceCompare(String s, String t) {
            int i = s.length() - 1,  j = t.length() - 1;
            while (i >= 0 || j >= 0) {
                int nextI = nextIndex(s, i);
                int nextJ = nextIndex(t, j);

                if (nextI < 0 && nextJ < 0) {
                    return true;
                }

                if (nextI < 0 || nextJ < 0) {
                    return false;
                }

                if (s.charAt(nextI) != t.charAt(nextJ)) {
                    return false;
                }

                i = nextI - 1;
                j = nextJ - 1;
            }

            return true;
        }

        private int nextIndex(String str, int index) {
            int backspaceCount = 0;
            while (index >= 0) {
                if (str.charAt(index) == '#') {
                    backspaceCount++;
                } else if (backspaceCount > 0) {
                    backspaceCount--;
                } else {
                    break;
                }
                index--;
            }

            return index;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.backspaceCompare("ad##", "a#b#")); // true
        System.out.println(solution.backspaceCompare("bbbextm", "bbb#extm")); // false
        System.out.println(solution.backspaceCompare("nzp#o#g", "b#nzp#o#g")); // true
    }
}
