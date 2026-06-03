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
    public int minMeetingRooms(List<Interval> intervals) {
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        for(Interval interval : intervals) {
            minStart = Math.min(minStart, interval.start);
            maxEnd = Math.max(maxEnd, interval.end);
        }
        int minRooms = 0;
        for(int i=minStart; i<=maxEnd; i++) {
            int conflicts = 0;
            for(Interval interval : intervals) {
                if(i>=interval.start && i<interval.end) {
                    conflicts++;
                }
            }
            minRooms = Math.max(minRooms, conflicts);
        }
        return minRooms;
    }
}
