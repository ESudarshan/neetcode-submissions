class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            int minLen = Integer.MAX_VALUE;
            for(int[] interval : intervals) {
                if(queries[i] >= interval[0] && queries[i] <= interval[1]) {
                    minLen = Math.min(minLen, interval[1] - interval[0] + 1);
                }
            }
            res[i] = minLen == Integer.MAX_VALUE ? -1 : minLen;
        }
        return res;
    }
}
