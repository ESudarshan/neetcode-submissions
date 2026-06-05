class Solution {

    int[][] mem;

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        mem = new int[m][n];
        for(int[] mr : mem) {
            Arrays.fill(mr, -1);
        }
        return uniquePaths(0, 0, m, n);
    }

    public int uniquePaths(int i, int j, int m, int n) {
        if(i == m-1 && j == n-1) {
            return 1;
        }
        
        if(i<0 || i>= m || j<0 || j>=n) {
            return 0;
        }

        if(mem[i][j] != -1) {
            return mem[i][j];
        }

        int res = uniquePaths(i+1, j, m, n) + uniquePaths(i, j+1, m, n);

        mem[i][j] = res;

        return res;
    }
}
