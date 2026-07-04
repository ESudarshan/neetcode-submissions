class Solution {

    int start = 0;
    int maxLen = 0;
    Boolean[][] mem;

    public String longestPalindrome(String s) {
        int n = s.length();
        mem = new Boolean[n][n];
        pal(s, 0, n-1);
        return s.substring(start, start + maxLen);
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

        if(isPal && j-i+1 > maxLen) {
            maxLen = j-i+1;
            start = i; 
        }

        

        pal(s, i+1, j);
        pal(s, i, j-1);
        
        mem[i][j] = isPal;
        return isPal;
    }
}
