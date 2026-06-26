class Solution {

    int[] mem;

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        return n - nonOverlapping(intervals, 0, n);
    }

    public int nonOverlapping(int[][] intervals, int i, int n) {
        if(i == n) {
            return 0;
        }
        if(mem[i] != -1) {
            return mem[i];
        }
        int res = 1;
        for(int k=i+1; k<n; k++) {
            if(intervals[i][1] <= intervals[k][0]) {
                res = Math.max(res, 1 + nonOverlapping(intervals, k, n));
            }
        }
        mem[i] = res;
        return res;
    }
}
