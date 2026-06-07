class Solution {

    int[] parent;
    int[] len;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        len = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            len[i] = 1;
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
        int j = i;
        while(j != parent[j]) {
            j = parent[j];
        }
        return parent[j];
    }
    
    public boolean union(int i, int j) {
        int poi =  find(i);
        int poj =  find(j);
        
        if(poi == poj) {
            return false;
        }

        if(poi < poj) {
            parent[poj] = poi;
            len[poi] += len[poj];
        } else {
            parent[poi] = poj;
            len[poj] = len[poi];
        }
        return true;
    }

}
