class Solution {

    int[][] dirs = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    

    public boolean[][] init(int r, int c) {
        boolean[][] visited = new boolean[r][c];
        for(int i=0; i<r; i++) {
            Arrays.fill(visited[i], false);
        }
        return visited;
    }

    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == Integer.MAX_VALUE) {
                    grid[i][j] = bfs(grid, i, j, r, c);
                }
            }
        }
    }

    public int bfs(int[][] grid, int ri, int ci, int r, int c) {
        boolean[][] visited = init(r, c);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ ri, ci});
        visited[ri][ci] = true;
        int d = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n ; i++) {
                int[] pair = q.poll();
                if(grid[pair[0]][pair[1]] == 0) {
                    return d;
                }
                for(int[] dir : dirs) {
                    ri = pair[0] + dir[0];
                    ci = pair[1] + dir[1];
                    if(ri >= 0 && ri < r && ci >= 0 && ci < c && grid[ri][ci] != -1 && !visited[ri][ci]) {
                        q.offer(new int[]{ ri, ci});
                        visited[ri][ci] = true;
                    }
                }
            }
            d++;
        }
        return Integer.MAX_VALUE;
    }

}
