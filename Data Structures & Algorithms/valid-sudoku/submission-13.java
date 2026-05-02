class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> square = new HashMap<>();
        for(int i=0; i<9; i++) {
            Set<Character> rowSeen = new HashSet<Character>();
            Set<Character> colSeen = new HashSet<Character>();
            for(int j=0; j<9; j++) {
                if(rowSeen.contains(board[i][j])) {
                    return false;
                }
                if(board[i][j] != '.') {
                    rowSeen.add(board[i][j]);
                }
            
                if(colSeen.contains(board[j][i])) {
                    return false;
                }
                if(board[j][i] != '.') {
                    colSeen.add(board[j][i]);
                }

                if(board[i][j] != '.') {
                    int sqIdx = (i/3)*3+(j/3);
                    square.putIfAbsent(sqIdx, new HashSet<>());
                    Set<Character> sqaureSeen = square.get(sqIdx);
                    if(sqaureSeen.contains(board[i][j])) {
                        return false;
                    }
                    sqaureSeen.add(board[i][j]);
                }

            }
        }
        return true;
    }
}
