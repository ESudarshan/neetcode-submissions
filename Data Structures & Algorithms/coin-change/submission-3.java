class Solution {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = change(coins, 0, n, amount);
        return res == Integer.MAX_VALUE || res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public int change(int[] coins, int i, int n, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(i >= n || amount < 0)  {
            return Integer.MAX_VALUE - 1;
        }
        // if(dp[i][amount] == -1) {
            dp[i][amount] = Math.min(1 + change(coins, i, n, amount - coins[i]),
                                        change(coins, i+1, n, amount));
        // }
        return dp[i][amount];
    }
}
