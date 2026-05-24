class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, mpdfs(grid, i, j, r, c));
                }
            }    
        }
        return maxArea;
    }

    public int mpdfs(int[][] grid, int ri, int ci, int r, int c) {
        if(ri < 0 || ci < 0 || ri >= r || ci >= c || grid[ri][ci] == 0) {
            return 0;
        }
        grid[ri][ci] = 0;
        return 1 + mpdfs(grid, ri-1, ci, r, c) 
                    + mpdfs(grid, ri+1, ci, r, c) 
                    + mpdfs(grid, ri, ci-1, r, c) 
                    + mpdfs(grid, ri, ci+1, r, c);
    }

}

