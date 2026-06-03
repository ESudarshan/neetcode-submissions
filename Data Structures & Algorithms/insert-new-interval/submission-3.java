class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n == 0) {
            return new int[][] { newInterval };
        }
        int newIStart = newInterval[0];
        int newIEnd = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for(int i=0; i<n; i++) {
            if(!inserted && newIStart < intervals[i][0]) {
                if(!res.isEmpty() && newIStart <= res.get(res.size()-1)[1]) {
                    res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], newIEnd);
                } else {
                    res.add(newInterval);
                }
                inserted = true;
                i--;
            } else {
                if(!res.isEmpty() && intervals[i][0] <= res.get(res.size()-1)[1]) {
                    res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
                } else {
                    res.add(intervals[i]);
                }
            }
        }
        if(!inserted) {
            if(!res.isEmpty() && newIStart <= res.get(res.size()-1)[1]) {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], newIEnd);
            } else {
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
