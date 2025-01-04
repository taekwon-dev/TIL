package problem_solving.leetcode.blind_75.meeting_room_ii;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ps_2025_01_03 {

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
            }
            pq.offer(interval.end);
        }
        return pq.size();
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
