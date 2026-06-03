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
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(Math.min(intervals.get(i).end, intervals.get(j).end) > Math.max(intervals.get(i).start, intervals.get(j).start)) {
                    return false;
                }
            }
        }
        return true;
    }
}