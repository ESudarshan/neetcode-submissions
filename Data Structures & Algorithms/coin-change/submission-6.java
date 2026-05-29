class Solution {

    int[] dp;
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = change(coins, n, amount);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public int change(int[] coins, int n, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(dp[amount] != -1) {
            return dp[amount];
        }
        int res = Integer.MAX_VALUE - 1;
        for(int k=0; k<n; k++) {
            if(amount - coins[k] >= 0 ) {
                res = Math.min(res, 1 + change(coins, n, amount - coins[k]));
            }
        }
        dp[amount] = res;
        return res;
    }
}
