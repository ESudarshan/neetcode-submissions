class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() > text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int m = text1.length();
        int n = text2.length();
        int[] prevDp = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + prevDp[j+1];
                } else {
                    dp[j] = Math.max(prevDp[j], dp[j+1]);
                }
            }
            int[] temp = prevDp;
            prevDp = dp;
            dp = temp;
        }
        return prevDp[0];
    }
}
