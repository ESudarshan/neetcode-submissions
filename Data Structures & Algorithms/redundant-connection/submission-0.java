class Solution {

    int[] parent;
    int[] rank;

    int find(int v) {
        int res = v;
        while(res != parent[res]) {
            res = parent[res];
        }
        return res;
    }

    boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2) {
            return false;
        }

        if(p1 >= p2) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) {
                return edge;
            }
        }
        
        return new int[] {-1, -1};
    }
}
