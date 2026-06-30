class Solution {
    private int[][] directions = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(i == 0 || i == r-1 || j == 0 || j == c-1) {
                    if(board[i][j] == 'O') {
                        bfs(board, i, j);
                    }
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } 
            }
        }
    }

    public void bfs(char[][] board, int ri, int ci) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {ri, ci});
        board[ri][ci] = 'T';

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                    q.offer(new int[]{nr, nc});
                    board[nr][nc] = 'T';
                }
            }

        }
    }
}
