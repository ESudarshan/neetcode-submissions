class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for(int a=1; a<=amount; a++) {
            dp[a] = amount + 1;
            for(int j=0; j<n; j++) {
                if(a - coins[j] >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[j]]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
