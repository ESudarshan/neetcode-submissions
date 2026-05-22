class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length; 
        for(int ri=0; ri<r; ri++) {
            for(int ci=0; ci<c; ci++) {
                if(dfs(board, ri, ci, r, c, word, 0, word.length())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int ri, int ci, int r, int c, String word, int wi, int w) {
        if(wi == w) {
            return true;
        }
        
        if(ri < 0 || ri >= r || ci < 0 || ci >= c || board[ri][ci] != word.charAt(wi)) {
            return false;
        }

        board[ri][ci] = '*';
        boolean res = dfs(board, ri-1, ci, r, c, word, wi+1, w) 
                        || dfs(board, ri+1, ci, r, c, word, wi+1, w)
                        || dfs(board, ri, ci-1, r, c, word, wi+1, w)
                        || dfs(board, ri, ci+1, r, c, word, wi+1, w);
        board[ri][ci] = word.charAt(wi);
        return res;
    }
}
