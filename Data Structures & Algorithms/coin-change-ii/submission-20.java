class Solution {

/*
    public int change(int[] coins, int i, int n, int amount) {
        if(amount == 0) {
            return 1;
        }
        if(i == n || amount < 0) {
            return 0;
        }        
        int res = 0;
        if(amount >= coins[i]) {
            res = change(coins, i, n, amount-coins[i]) + change(coins, i+1, n, amount);
        }
        return res;
    }
*/


    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int[][] dp = new int[n+1][amount+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<=amount; j++) {
                if(j >= coins[i]) {
                    dp[i][j] = dp[i][j-coins[i]] + dp[i+1][j];
                }
            }
        }

        return dp[0][amount];
    }
}
