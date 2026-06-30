class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(i == 0 || i == r-1 || j == 0 || j == c-1) {
                    if(board[i][j] == 'O') {
                        dfs(board, i, j, r, c);
                    }
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                } 
            }
        }
    }

    public void dfs(char[][] board, int ri, int ci, int r, int c) {
        if(ri<0 || ri>=r || ci<0 || ci>=c || board[ri][ci]!='O') {
            return;
        }
        board[ri][ci] = '#';
        dfs(board, ri-1, ci, r, c);
        dfs(board, ri+1, ci, r, c);
        dfs(board, ri, ci-1, r, c);
        dfs(board, ri, ci+1, r, c);
    }
}
