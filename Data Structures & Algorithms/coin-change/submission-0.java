class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = change(coins, 0, n, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int change(int[] coins, int i, int n, int amount, int count) {
        if(amount == 0) {
            return count;
        }
        if(i == n || amount < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(change(coins, i, n, amount - coins[i], count + 1),
                        change(coins, i+1, n, amount, count));
    }
}
