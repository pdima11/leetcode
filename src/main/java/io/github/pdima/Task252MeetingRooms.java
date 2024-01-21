package io.github.pdima;

import java.util.Comparator;
import java.util.List;

public class Task252MeetingRooms {

    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Solution {
        public boolean canAttendMeetings(List<Interval> intervals) {
            intervals.sort(Comparator.comparingInt(a -> a.start));

            for (int i = 1; i < intervals.size(); i++) {
                if (intervals.get(i - 1).end > intervals.get(i).start) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canAttendMeetings(List.of(new Interval(5, 8), new Interval(9, 15)))); // true
        System.out.println(solution.canAttendMeetings(List.of(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)))); // false
    }
}
