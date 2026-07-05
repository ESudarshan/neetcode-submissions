
class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<amount+1; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                } else if(i == n) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        
        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=amount; j++) {
                if(coins[i] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i]], dp[i+1][j]);
                } else {
                    dp[i][j] = dp[i+1][j];
                }                
            }
        }
        
        return dp[0][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[0][amount];
    }

}