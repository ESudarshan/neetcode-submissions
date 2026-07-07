class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = -1;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=maxLen; j++) {
                if(i+j<=n && wordSet.contains(s.substring(i, i+j))) {
                    dp[i] = dp[i+j];
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        
        return dp[0];
    }

}
