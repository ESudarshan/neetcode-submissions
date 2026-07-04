class Solution {

    int count = 0; 
    Boolean[][] mem;

    public int countSubstrings(String s) {
        int n = s.length();
        mem = new Boolean[n][n];
        pal(s, 0, n-1);
        return count;
    }

    public boolean pal(String s, int i, int j) {
        if(i > j) {
            return false;
        }

        if(mem[i][j] != null) {
            return mem[i][j];
        }

        boolean isPal = false;
        if(s.charAt(i) == s.charAt(j)
            && (j-i+1 <= 3 || pal(s, i+1, j-1))) {
            isPal = true;
        }

        if(isPal) {
            count++; 
        }

        mem[i][j] = isPal;

        pal(s, i+1, j);
        pal(s, i, j-1);
        
        return isPal;
    }
}
