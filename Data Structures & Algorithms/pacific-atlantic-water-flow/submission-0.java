class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[][] visited;
    int[][] dirs = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public void init(boolean[][] visited) {
        for(int i=0; i<visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        visited = new boolean[r][c]; 
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                init(visited);
                bfs(i, j, r, c, heights);
            }
        }
        return ans;
    }

    public void bfs(int ri, int ci, int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {ri, ci});
        visited[ri][ci] = true;
        boolean pacific = false;
        boolean atlantic = false;
        while(!q.isEmpty() && !(pacific && atlantic)) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int[] front = q.remove();
                for(int[] dir : dirs) {
                    int rd = front[0] + dir[0];
                    int cd = front[1] + dir[1];
                    if(rd>=0 && rd<r && cd>=0 && cd<c && !visited[rd][cd]) {
                        if(grid[rd][cd] <= grid[front[0]][front[1]]) {
                            visited[rd][cd] = true;
                            q.add(new int[] {rd, cd});
                        }
                    } else if(rd<0 || cd<0) {
                        pacific = true;
                    } else if(rd>=r || cd>=c) {
                        atlantic = true;
                    }
                }                
            }
        }
        if(pacific && atlantic) {
            ans.add(Arrays.asList(ri, ci));
        }
    }

}
