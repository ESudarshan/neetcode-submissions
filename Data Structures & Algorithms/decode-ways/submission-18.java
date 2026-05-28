class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp1 = 0;
        int dp2 = 1;
        
        for(int i=1; i<=n; i++) {
            int dp = 0;
            if(isValid1DNumber(s, i-1, n)) {
                dp = dp2;
            } else {
                dp = 0;
            }
            if(isValid2DNumber(s, i-2, n)) {
                dp += dp1;
            }
            dp1 = dp2;
            dp2 = dp;
        }
        return dp2;
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
