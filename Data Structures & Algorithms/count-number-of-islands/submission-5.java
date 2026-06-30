class Solution {

    int[][] dir = new int[][] {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int numIslands = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == '1') {
                    mpbfs(grid, i, j, r, c);
                    numIslands++;
                }
            }    
        }
        return numIslands;
    }

    public void mpbfs(char[][] grid, int ri, int ci, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ri, ci});
        grid[ri][ci] = '0';
        while(!q.isEmpty()) {
            for(int k=0; k<q.size(); k++) {
                int[] land = q.remove();
                int i = land[0];
                int j =  land[1]; 

                for(int[] d : dir) {
                    if(i + d[0] >= 0 
                        && i + d[0] < r 
                        && j + d[1] >= 0 
                        && j + d[1] < c
                        && grid[i+d[0]][j+d[1]] != '0') {
                            q.add(new int[]{i + d[0], j + d[1]});
                            grid[i + d[0]][j + d[1]] = '0';
                        }
                }
            }
        }
    }

}
