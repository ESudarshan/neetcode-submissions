class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> output = new ArrayList<>();
        int r = board.length;
        int c = board[0].length;
        for(String word : words) {
            boolean found = false;
            int n = word.length();
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(backtrack(word, 0, n, board, i, j, r, c)) {
                        output.add(word);
                        found = true;
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
        }
        return output;
    }

    public boolean backtrack(String word, int wi, int n, char[][] board, int ri, int ci, int r, int c) {
        if(wi == n) {
            return true;
        }
        if(ri < 0 || ri >= r || ci < 0 || ci >= c) {
            return false;
        }
        if(word.charAt(wi) != board[ri][ci]) {
            return false;
        }
        board[ri][ci] = '*';
        boolean res = backtrack(word, wi+1, n, board, ri, ci-1, r, c) 
                        || backtrack(word, wi+1, n, board, ri-1, ci, r, c)
                        || backtrack(word, wi+1, n, board, ri+1, ci, r, c) 
                        || backtrack(word, wi+1, n, board, ri, ci+1, r, c);
        board[ri][ci] = word.charAt(wi);
        return res;
    }

}
