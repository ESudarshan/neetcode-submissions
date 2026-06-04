class Solution {

    int[][] dp;

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        dp = new int[n][n+1];
        for(int[] dpr : dp) {
             Arrays.fill(dpr, -1);
        }   
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return n - nonOverlapping(intervals, 0, -1, n);
    }

    public int nonOverlapping(int[][] intervals, int i, int j, int n) {
        if(i == n) {
            return 0;
        }
        if(dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }
        int res = nonOverlapping(intervals, i + 1, j, n);
        if(j == -1 || intervals[j][1] <= intervals[i][0]) {
            res = Math.max(res, 1 + nonOverlapping(intervals, i + 1, i, n));
        }
        dp[i][j + 1] = res;
        return res;
    }
}
