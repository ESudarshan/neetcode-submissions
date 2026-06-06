class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjl = new HashMap<>();
        for(int[] time : times) {
            adjl.putIfAbsent(time[0], new ArrayList<>());
            adjl.get(time[0]).add(new int[] {time[1], time[2]}); 
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] {k, 0});

        Set<Integer> visited = new HashSet<>();
        int maxDelay = -1;

        while(!minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int u = pair[0];
            int uw = pair[1];

            if(visited.contains(u)) {
                continue;
            }
            visited.add(u);

            maxDelay = uw;

            if(adjl.containsKey(u)) {
                for(int[] uvpair : adjl.get(u)) {
                    int v = uvpair[0];
                    int uvw = uvpair[1];
                    if(!visited.contains(v)) {
                        minHeap.offer(new int[] {v, uw + uvw});
                    }
                }
            }
        }

        return visited.size() == n ? maxDelay : -1;
    }
}