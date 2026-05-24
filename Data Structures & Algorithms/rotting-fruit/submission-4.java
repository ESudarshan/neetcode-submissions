class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        int allFruits = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                }
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    allFruits++;
                }
            }
        }

        int mins = 0;
        int rottenFruits = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int[] cell = q.remove();
                int ri = cell[0];
                int ci = cell[1];

                grid[ri][ci] = 2;
                rottenFruits++;

                for(int[] dir : dirs) {
                    ri = cell[0] + dir[0];
                    ci = cell[1] + dir[1];
                    
                    if(ri>=0 && ri<r && ci>=0 && ci<c && grid[ri][ci]==1 && !visited[ri][ci]) {
                        visited[ri][ci] = true;
                        q.add(new int[] {ri, ci});
                    }
                }
            }
            mins++;
        }

        if(allFruits == 0) {
            return 0;
        } else if (allFruits == rottenFruits){
            return mins - 1;
        } else {
            return -1;
        }
    }
}
