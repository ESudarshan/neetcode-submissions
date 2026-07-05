class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--) {
            dp[i] = 0;
            if(isValid1DNumber(s, i, n)) {
                dp[i] += dp[i+1];
            }
            if(isValid2DNumber(s, i, n)) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    public boolean isValid1DNumber(String s, int i, int n) {
        return i <= n - 1 && s.charAt(i) >= '1' && s.charAt(i) <= '9';
    }

    public boolean isValid2DNumber(String s, int i, int n) {
        return (i + 1) <= n - 1 
                && (s.charAt(i) == '1' 
                    || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'));
    }

}
