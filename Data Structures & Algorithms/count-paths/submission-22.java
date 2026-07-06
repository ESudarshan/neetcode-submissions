class Solution {

    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        for(int[] mr : mem) {
            Arrays.fill(mr, -1);
        }
        return uniquePaths(0, 0, m, n, mem);
    }

    public int uniquePaths(int i, int j, int m, int n, int[][] mem) {
        if(i == m-1 && j == n-1) {
            return 1;
        }
        
        if(i>= m || j>=n) {
            return 0;
        }

        if(mem[i][j] != -1) {
            return mem[i][j];
        }

        int res = uniquePaths(i+1, j, m, n, mem) + uniquePaths(i, j+1, m, n, mem);

        mem[i][j] = res;

        return res;
    }
}
