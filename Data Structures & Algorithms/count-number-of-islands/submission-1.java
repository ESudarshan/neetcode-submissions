class Solution {

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == '1') {
                    mpdfs(grid, i, j, r, c);
                    count++;
                }
            }    
        }
        return count;
    }

    public void mpdfs(char[][] grid, int ri, int ci, int r, int c) {
        if(ri < 0 || ci < 0 || ri >= r || ci >= c || grid[ri][ci] == '0') {
            return;
        }
        grid[ri][ci] = '0';
        mpdfs(grid, ri-1, ci, r, c);
        mpdfs(grid, ri+1, ci, r, c);
        mpdfs(grid, ri, ci-1, r, c);
        mpdfs(grid, ri, ci+1, r, c);
    }

}
