class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    List<Integer> visited = new ArrayList<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        if(dfs(0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    public boolean dfs(int curr, int parent) {
        if(cycle.contains(curr)) {
            return true;
        }
        cycle.add(curr);
        for(int child : map.getOrDefault(curr, new ArrayList<>())) {
            if(child != parent && dfs(child, curr)) {
                return true;
            }
        }
        cycle.remove(curr);
        visited.add(curr);
        return false;
    }

}
