class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(intervals.length <= 1) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(intervals[0]);
        for(int i=1; i<n; i++) {
            int prevEnd = res.get(res.size()-1)[1];
            int currStart = intervals[i][0];
            if(prevEnd >= currStart) {
                res.get(res.size()-1)[1] = Math.max(prevEnd, intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
