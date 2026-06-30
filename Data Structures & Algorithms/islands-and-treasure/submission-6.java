class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true; 
                }
            }
        }
        int d = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int[] curr = q.remove();
                int ri = curr[0];
                int ci = curr[1];
                
                for(int[] dir : dirs) {
                    ri = curr[0] + dir[0];
                    ci = curr[1] + dir[1];
                    if(ri>=0 && ri<r && ci>=0 && ci<c && grid[ri][ci] == Integer.MAX_VALUE) {
                        q.add(new int[] {ri, ci});
                        grid[ri][ci] = d;
                    }
                }
            }
            d++;
        }
    }
}
