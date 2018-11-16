package interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> is = new ArrayList<>();
        Interval i = new Interval();

        is.add(new Interval(2, 4));
        is.add(new Interval(5, 7));
        is.add(new Interval(8, 10));
        is.add(new Interval(11, 13));

        i = new Interval(3, 6);

        new InsertInterval().insert(is, i);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rl = new ArrayList<>();
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if (intervals.get(intervals.size() - 1).end < newInterval.start) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval interval;
        for (int i = 0; i < intervals.size(); i++) {
            interval = intervals.get(i);
            if (interval.end < newInterval.start) rl.add(interval);
            else if (interval.start > newInterval.end) {
                rl.add(newInterval);
                rl.addAll(intervals.subList(i, intervals.size()));
                return rl;
            } else {
                if ((interval.start <= newInterval.start && interval.end >= newInterval.start) ||
                        (interval.start <= newInterval.end && interval.end >= newInterval.end)) {
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    newInterval.end = Math.max(interval.end, newInterval.end);
                }
            }
        }
        if (!rl.contains(newInterval)) rl.add(newInterval);
        return rl;
    }
}
