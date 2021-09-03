/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public class Point {
        int start;
        int end;
        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        List<Point> arr = new ArrayList<>();
        for (Interval interval : intervals) {
            arr.add(new Point(interval.start, 1));
            arr.add(new Point(interval.end, -1));
        }

        Collections.sort(arr, (a, b) -> {
            if (a.start == b.start) return a.end - b.end;
            return a.start - b.start;
        });

        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            count += arr.get(i).end;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}