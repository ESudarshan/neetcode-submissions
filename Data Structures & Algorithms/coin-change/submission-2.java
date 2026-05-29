class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = change(coins, 0, n, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int change(int[] coins, int i, int n, int total, int amount, int count) {
        if(total == amount) {
            return count;
        }
        if(i == n || total > amount) {
            return Integer.MAX_VALUE;
        }
        return Math.min(change(coins, i, n, total + coins[i], amount, count + 1),
                        change(coins, i+1, n, total, amount, count));
    }
}
