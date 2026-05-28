class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<=n; i++) {
            if(isValid1DNumber(s, i-1, n)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = 0;
            }
            if(isValid2DNumber(s, i-2, n)) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public boolean isValid1DNumber(String s, int i, int n) {
        return s.charAt(i) != '0';
    }

    public boolean isValid2DNumber(String s, int i, int n) {
    return i >= 0 
                && (s.charAt(i) == '1' 
                    || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'));
    }

}
