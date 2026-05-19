class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        int n = points.length; 
        for(int i=0; i<n; i++) {
            maxHeap.offer(points[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int i = 0;
        int[][] ans = new int[k][2];
        while(!maxHeap.isEmpty()) {
            ans[i] = maxHeap.poll();
            i++;
        }
        return ans;
    }
}
