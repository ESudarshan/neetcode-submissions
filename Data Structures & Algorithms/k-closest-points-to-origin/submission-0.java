class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey()));
        int n = points.length; 
        for(int i=0; i<n; i++) {
            double dist = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            maxHeap.offer(new Pair(dist, points[i]));
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int i = 0;
        int[][] ans = new int[maxHeap.size()][2];
        for(Pair<Double, int[]> pair : maxHeap) {
            ans[i] = pair.getValue();
            i++;
        }
        return ans;
    }
}
