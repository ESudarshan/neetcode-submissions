class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int m = intervals.length;
        int[] res = new int[n];
        int[][] newQueries = new int[n][2];
        for(int i=0; i<n; i++) {
            newQueries[i][0] = queries[i];
            newQueries[i][1] = i;
        }
        Arrays.sort(newQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int j = 0;
        for(int i=0; i<n; i++) {
            int query = newQueries[i][0];
            while(j< m && intervals[j][0] <= query) {
                minHeap.offer(new int[] {intervals[j][1]-intervals[j][0]+1, intervals[j][1]});
                j++;
            }
            while(!minHeap.isEmpty() && query > minHeap.peek()[1]) {
                minHeap.poll();
            }
            if(minHeap.isEmpty()) {
                res[newQueries[i][1]] = -1;
            } else {
                res[newQueries[i][1]] = minHeap.peek()[0];
            }
        }
        return res;
    }
}
