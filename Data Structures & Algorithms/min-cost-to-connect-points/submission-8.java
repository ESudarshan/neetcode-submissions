class Solution {
    public int minCostConnectPoints(int[][] points) {
        int v = points.length;

        Map<Integer, List<int[]>> adjl = new HashMap<>();
        for(int i=0; i<v; i++) {
            for(int j=i+1; j<v; j++) {
                int md = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjl.putIfAbsent(i, new ArrayList<>());
                adjl.get(i).add(new int[] {md, j});
                adjl.putIfAbsent(j, new ArrayList<>());
                adjl.get(j).add(new int[] {md, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] {0, 0});

        int res = 0;
        while(!minHeap.isEmpty()) {
            int[] v1w1 = minHeap.poll();
            int w1 = v1w1[0];
            int v1 = v1w1[1];

            if(visited.contains(v1)) {
                continue;
            }
            visited.add(v1);

            res += w1;

            for(int[] v2w2 : adjl.getOrDefault(v1, new ArrayList<>())) {
                int w2 = v2w2[0];
                int v2 = v2w2[1];
                if(!visited.contains(v2)) {
                    minHeap.offer(new int[] {w2, v2});
                }
            }
        }

        return res;
    }
}