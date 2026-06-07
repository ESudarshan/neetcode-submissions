class Solution {
    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        if(v <= 1) {
            return 0;
        }

        int[] weight = new int[v];
        Arrays.fill(weight, Integer.MAX_VALUE);

        boolean[] visited = new boolean[v];
        int visits = 1;
        int res = 0;

        weight[0] = 0;
        while(visits <= v) {
            int currVertex = -1;
            int currWeight = Integer.MAX_VALUE;

            for(int i=0; i<v; i++) {
                if(!visited[i]) {
                    if(weight[i] < currWeight) {
                        currWeight = weight[i];
                        currVertex = i;
                    }
                }
            }

            visited[currVertex] = true;
            visits++;
            res += currWeight;

            for(int i=0; i<v; i++) {
                if(!visited[i]) {
                    int md = Math.abs(points[currVertex][0] - points[i][0]) + Math.abs(points[currVertex][1] - points[i][1]);
                    if(md < weight[i]) {
                        weight[i] = md;
                    }                    
                }
            }

        }

        return res;
    }
}
