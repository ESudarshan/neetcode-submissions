class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> path = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != (n - 1)) {
            return false;
        }

        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        if(!dfs(0, -1)) {
            return false;
        }
        return path.size() == n;
    }

    public boolean dfs(int curr, int parent) {
        if(path.contains(curr)) {
            return false;
        }
        path.add(curr);
        for(int child : map.getOrDefault(curr, new ArrayList<>())) {
            if(child == parent) {
                continue;
            }
            if(!dfs(child, curr)) {
                return false;
            }
        }
        return true;
    }

}
