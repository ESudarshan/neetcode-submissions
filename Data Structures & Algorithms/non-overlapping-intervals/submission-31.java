class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return n - nonOverlapping(intervals, 0, -1, n);
    }

    public int nonOverlapping(int[][] intervals, int i, int j, int n) {
        if(i == n) {
            return 0;
        }
        int res = nonOverlapping(intervals, i + 1, j, n);
        if(j == -1 || intervals[j][1] <= intervals[i][0]) {
            res = Math.max(res, 1 + nonOverlapping(intervals, i + 1, i, n));
        }
        return res;
    }
}
