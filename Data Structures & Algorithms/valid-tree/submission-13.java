class Solution {

    int[] parent;
    int[] rank;

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;
        for(int[] edge : edges) {
            if(!union(edge[0], edge[1])) {
                return false;
            }
            components--;
        }

        return components == 1;
    }


    public int find(int v) {
        if(v == parent[v]) {
            return v;
        }
        parent[v] = find(parent[v]);
        return parent[v];
    }

    public boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        
        if(p1 == p2) {
            return false;
        }

        if(rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }

}
