class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    int[] area = new int[1];
                    mpdfs(grid, i, j, r, c, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }    
        }
        return maxArea;
    }

    public void mpdfs(int[][] grid, int ri, int ci, int r, int c, int[] area) {
        if(ri < 0 || ci < 0 || ri >= r || ci >= c || grid[ri][ci] == 0) {
            return;
        }
        grid[ri][ci] = 0;
        area[0]++;
        mpdfs(grid, ri-1, ci, r, c, area);
        mpdfs(grid, ri+1, ci, r, c, area);
        mpdfs(grid, ri, ci-1, r, c, area);
        mpdfs(grid, ri, ci+1, r, c, area);
    }

}

