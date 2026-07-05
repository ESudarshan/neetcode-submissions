class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int next2 = 0;
        int next1 = 1;
        int dp = 0;
        for(int i=n-1; i>=0; i--) {
            dp = 0;
            if(isValid1DNumber(s, i, n)) {
                dp += next1;
            }
            if(isValid2DNumber(s, i, n)) {
                dp += next2;
            }
            next2 = next1;
            next1 = dp;
        }
        return dp;
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
