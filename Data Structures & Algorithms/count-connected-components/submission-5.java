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

    int union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        
        if(p1 == p2) {
            return 0;
        }

        // if(rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
       /* } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
*/
        return 1;
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int ans = n;
        for(int[] edge : edges) {
            ans -= union(edge[0], edge[1]);
        }
        return ans;
    }
}
