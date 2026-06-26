class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        int rem = 0; 
        while(rem < n && intervals[rem][1] < newInterval[0]) {
            res.add(intervals[rem]);
            rem++;
        }

        while(rem < n && intervals[rem][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[rem][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[rem][1]);
            rem++;
        }

        res.add(newInterval);

        while(rem < n) {
            res.add(intervals[rem]);
            rem++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}
