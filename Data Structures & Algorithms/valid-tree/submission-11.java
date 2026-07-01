class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, -1});
        visited.add(0);

        while(!q.isEmpty()) {
            int qs = q.size();
            for(int i=0; i<qs; i++) {
                int[] entry = q.remove();
                int curr = entry[0];
                int parent = entry[1];
                for(int child : adjList.get(curr)) {
                    if(parent == child) {
                        continue;
                    }
                    if(visited.contains(child)) {
                        return false;
                    }
                    q.add(new int[] {child, curr});
                    visited.add(child);
                } 
            }
        }

        return visited.size() == n;
    }
}
