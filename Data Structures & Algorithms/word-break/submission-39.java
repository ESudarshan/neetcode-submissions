class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--) {
            for(String word : wordDict) {
                int wl = word.length();
                if(i+wl<=n && word.equals(s.substring(i, i+wl))) {
                    dp[i] = dp[i+wl];
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        
        return dp[0];
    }

}
