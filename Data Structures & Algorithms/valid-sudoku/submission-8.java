class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            Set<Character> rowSeen = new HashSet<Character>();
            Set<Character> colSeen = new HashSet<Character>();
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(rowSeen.contains(board[i][j])) {
                        System.out.println("rowSeen="+rowSeen);
                        System.out.println("i="+i+"j="+j);
                        return false;
                    }
                    rowSeen.add(board[i][j]);
                }
                 if(board[j][i] != '.') {
                    if(colSeen.contains(board[j][i])) {
                        System.out.println("colSeen=" +colSeen);
                        System.out.println("i="+i+"j="+j);
                        return false;
                    }
                    colSeen.add(board[j][i]);
                }
            }
        }
        

        for(int k=0; k<9; k=k+3) {
            for(int l=0; l<9; l=l+3) {
                Set<Character> seen = new HashSet<>();
                for(int i=k; i<k+3; i++) {
                    for(int j=l; j<l+3; j++) {
                        if(seen.contains(board[i][j])) {
                            return false;
                         }
                        if(board[i][j] != '.') {
                            seen.add(board[i][j]);
                        }
                    }
                }    
                System.out.println(seen);
            }
        }


        return true;
    }
}
