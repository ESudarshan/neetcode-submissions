/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for(int i=0; i<n-1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if(current.end > next.start) {
                return false;
            }
        }
        return true;
    }
}
