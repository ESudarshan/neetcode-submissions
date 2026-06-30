class Solution {

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();


        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(i == 0 || j == 0) {
                    pq.add(new int[] {i, j});
                    pacific[i][j] = true;
                }
                if(i == r-1 || j == c-1) {
                    aq.add(new int[] {i, j});
                    atlantic[i][j] = true;
                }
            }
        }

        msbfs(heights, pq, pacific, r, c);
        msbfs(heights, aq, atlantic, r, c);

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void msbfs(int[][] heights, Queue<int[]> q, boolean[][] ocean, int r, int c) {
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int[] front = q.remove();
                int ri = front[0];
                int ci = front[1];
                for(int[] dir : dirs) {
                    int rd = ri + dir[0];
                    int cd = ci + dir[1];

                    if(rd>=0 && rd<r && cd>=0 && cd<c && !ocean[rd][cd] && heights[rd][cd]>=heights[ri][ci]) {
                        q.add(new int[] {rd, cd});
                        ocean[rd][cd] = true;
                    }
                }

            }
        }
    }

}
