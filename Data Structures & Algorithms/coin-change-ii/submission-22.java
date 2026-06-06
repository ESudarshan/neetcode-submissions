class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int[] prevDp = new int[amount+1];
        prevDp[0] = 1;
        
        for(int i=n-1; i>=0; i--) {
            int[] dp = new int[amount+1];
            dp[0] = 1;
            for(int j=1; j<=amount; j++) {
                if(j >= coins[i]) {
                    dp[j] = dp[j-coins[i]] + prevDp[j];
                }
            }
            prevDp = dp;
        }

        return prevDp[amount];
    }
}
