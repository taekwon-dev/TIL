package problem_solving.leetcode.blind_75.meeting_room_i;

import java.util.Comparator;
import java.util.List;

public class ps_2025_01_03 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);

            if (prev.end > curr.start) {
                return false;
            }
        }
        return true;
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
