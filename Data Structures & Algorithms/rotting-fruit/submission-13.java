class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dirs = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                if(grid[i][j] == 1) {
                   fresh++;
                }
            }
        }

        int mins = 0;
        while(!q.isEmpty() && fresh > 0) {
            int n = q.size();
            for(int k=0; k<n; k++) {
                int[] cell = q.remove();
                int i = cell[0];
                int j = cell[1];

                for(int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni >=0 && ni < r && nj >=0 && nj < c && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        q.add(new int[] {ni, nj});
                        fresh--;
                    }
                }
            }
            mins++;
        }

        return fresh == 0 ? mins : -1;
    }
}
