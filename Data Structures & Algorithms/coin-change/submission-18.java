class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = change(coins, 0, n, amount);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public int change(int[] coins, int i, int n, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(i == n) {
            return Integer.MAX_VALUE - 1;
        }

        int res;
        if(coins[i] <= amount) {
            res = Math.min(1 + change(coins, i, n, amount - coins[i]), change(coins, i+1, n, amount));
        } else {
            res = change(coins, i+1, n, amount);
        }

        return res;
    }
}
