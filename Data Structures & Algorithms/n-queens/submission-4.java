class Solution {

    List<List<String>> output = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = init(n);
        dfs(board, 0, n);
        return output;
    }
    
    public char[][] init(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public void dfs(char[][] board, int ri, int n) {
        if(ri == n) {
            output.add(getBoardString(board));
            return;
        }

        for(int ci=0; ci<n ; ci++) {
            if(isSafe(board, ri, ci)) {
                board[ri][ci] = 'Q';
                dfs(board, ri+1, n);
                board[ri][ci] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int ri, int ci) {
        for(int r=0; r<ri; r++) {
            if(board[r][ci] == 'Q') {
                return false;
            }
        }

        int r = ri-1;
        int c = ci-1;
        while(r >=0 && c >=0) {
            if(board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        
        r = ri-1;
        c = ci+1;
        while(r >=0 && c < board[r].length) {
            if(board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    public List<String> getBoardString(char[][] board) {
        List<String> boardString = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            boardString.add(String.valueOf(board[i]));
        }
        return boardString;
    }

}
