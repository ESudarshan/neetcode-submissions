class Solution {

    List<List<String>> output = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();

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
                cols.add(ci);
                negDiag.add(ri-ci);
                posDiag.add(ri+ci);
                board[ri][ci] = 'Q';

                dfs(board, ri+1, n);
            
                board[ri][ci] = '.';
                posDiag.remove(ri+ci);
                negDiag.remove(ri-ci);
                cols.remove(ci);
            }
        }
    }

    public boolean isSafe(char[][] board, int ri, int ci) {
        if(cols.contains(ci) || negDiag.contains(ri-ci) || posDiag.contains(ri+ci)) {
            return false;
        }
        return true;
    }

    public List<String> getBoardString(char[][] board) {
        List<String> boardString = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            boardString.add(new String(board[i]));
        }
        return boardString;
    }

}
