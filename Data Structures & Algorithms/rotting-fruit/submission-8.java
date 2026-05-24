class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int freshFruits = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
                if(grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }

        int mins = 0;
        while(!q.isEmpty() && freshFruits>0) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int[] cell = q.remove();
                int ri = cell[0];
                int ci = cell[1];

                for(int[] dir : dirs) {
                    ri = cell[0] + dir[0];
                    ci = cell[1] + dir[1];
                    
                    if(ri>=0 && ri<r && ci>=0 && ci<c && grid[ri][ci]==1) {
                        grid[ri][ci] = 2;
                        freshFruits--;
                        q.add(new int[] {ri, ci});
                    }
                }
            }
            mins++;
        }

        if(freshFruits == 0) {
            return mins;
        }
        return -1;
    }
}
