class Solution {

    int[][] dirs = new int[][] {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, r, c));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int ri, int ci, int r, int c) {
        int area = 0;
        Queue<int[]> q = new LinkedList<>();
        grid[ri][ci] = 0;
        q.offer(new int[] { ri, ci });
        while(!q.isEmpty()) {
            int[] pair = q.poll();
            area++;
            for(int[] dir : dirs) {
                ri = pair[0] + dir[0];
                ci = pair[1] + dir[1];
                if(ri >= 0 && ci >= 0 && ri < r && ci < c && grid[ri][ci] == 1) {
                    grid[ri][ci] = 0;
                    q.offer(new int[] { ri, ci });
                }
            }
        }
        return area;
    }
}