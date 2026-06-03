class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int rem = 0; 
        for(int i=rem; i<n; i++) {
            if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                rem = i + 1;
            } else {
                break;
            }
        }

        for(int i=rem; i<n; i++) {
            if(intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                rem = i + 1;
            } else {
                break;
            }
        }

        res.add(newInterval);

        for(int i=rem; i<n; i++) {
            res.add(intervals[i]);
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}
