class Solution {

    int[][] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] dpr : dp) {
            Arrays.fill(dpr, -1);
        }
        return wBreak(s, 0, 0, n, new HashSet<>(wordDict));
    }

    public boolean wBreak(String s, int start, int end, int n, Set<String> wordDict) {
        if(start == n) {
            return true;
        }
        if(end == n) {
            return false;
        }
        if(dp[start][end] != -1) {
            return dp[start][end] == 0 ? false : true;
        }
        boolean res = wBreak(s, start, end + 1, n, wordDict);
        if(wordDict.contains(s.substring(start, end + 1))) {
            res = res || wBreak(s, end + 1, end + 1, n, wordDict);
        }
        dp[start][end] = res ? 1 : 0;
        return res;
    }
}
