class Solution {

    List<List<Integer>> adjl = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        int c = 0;
        for(int i=0; i<n; i++) {
            adjl.add(new ArrayList<>());
        }

        int e = edges.length;
        for(int i=0; i<e; i++) {
            adjl.get(edges[i][0]).add(edges[i][1]);
            adjl.get(edges[i][1]).add(edges[i][0]);
        }

        for(int v=0; v<n; v++) {
            if(!visited.contains(v)) {
                bfs(v);
                c++;
            }
        }

        return c;
    }

    public void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited.add(v);

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int cv = q.remove();
                for(int nv : adjl.get(cv)) {
                    if(!visited.contains(nv)) {
                        q.add(nv);
                        visited.add(nv);
                    }
                }
            }
        }
    }

}
