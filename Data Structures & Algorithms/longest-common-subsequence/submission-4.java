class Solution {

    

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        Integer[][] mem = new Integer[m][n];
        return lcs(text1, 0, m, text2, 0, n, mem);
    }

    public int lcs(String text1, int i1, int m, String text2, int i2, int n, Integer[][] mem) {
        if(i1 == m || i2 == n) {
            return 0;
        }

        if(mem[i1][i2] != null) {
            return mem[i1][i2];
        }

        int res = Math.max(lcs(text1, i1+1, m, text2, i2, n, mem), lcs(text1, i1, m, text2, i2+1, n, mem));
        if(text1.charAt(i1) == text2.charAt(i2)) {
            res = 1 + lcs(text1, i1+1, m, text2, i2+1, n, mem);
        } 
        mem[i1][i2] = res;

        return res;
    }
}
