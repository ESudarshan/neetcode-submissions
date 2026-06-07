class Solution {

    int[] parent;
    int[] size;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int md = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {md, i, j});
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        int res = 0;
        for(int[] edge : edges) {
            if(union(edge[1], edge[2])) {
                res += edge[0];
            }
        }

        return res;
    }

    public int find(int i) {
        if(i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    
    public boolean union(int i, int j) {
        int poi =  find(i);
        int poj =  find(j);
        
        if(poi == poj) {
            return false;
        }

        if(size[poi] < size[poj]) {
            parent[poi] = poj;
            size[poj] += size[poi];
        } else {
            parent[poj] = poi;
            size[poi] += size[poj];
        }
        return true;
    }

}
