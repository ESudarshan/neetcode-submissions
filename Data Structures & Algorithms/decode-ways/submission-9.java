class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<=n; i++) {
            if(s.charAt(i-1) == '0') {
                 dp[i] = 0;
            } else {
                dp[i] = dp[i-1];
            }
            if(isValid2DNumber(s, i-1, n)) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public boolean isValid2DNumber(String s, int i, int n) {
        return (i - 1) >= 0 
                && (s.charAt(i-1) == '1' 
                    || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'));
    }

}
