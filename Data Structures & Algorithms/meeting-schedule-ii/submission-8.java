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
        int n = intervals.size();
        
        int[] start = new int[n];
        int[] end = new int[n]; 
 
        for(int i=0; i<n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int e = 0;
        int s = 0;
        int conflicts = 0;
        int maxConflicts = 0;
        while(e < n) {
            while(s < n && start[s] < end[e]) {
                conflicts++;
                maxConflicts = Math.max(maxConflicts, conflicts);
                s++;
            }
            e++;
            conflicts--;
        }
        return maxConflicts;
    }
}
