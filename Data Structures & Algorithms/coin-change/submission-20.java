class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] mem = new int[n][amount+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        }
        int res = change(coins, 0, n, amount, mem);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public int change(int[] coins, int i, int n, int amount, int[][] mem) {
        if(amount == 0) {
            return 0;
        }
        if(i == n) {
            return Integer.MAX_VALUE - 1;
        }

        if(mem[i][amount] != -1) {
            return mem[i][amount];
        }

        int res;
        if(coins[i] <= amount) {
            res = Math.min(1 + change(coins, i, n, amount - coins[i], mem), change(coins, i+1, n, amount, mem));
        } else {
            res = change(coins, i+1, n, amount, mem);
        }
        mem[i][amount] = res;
        return res;
    }
}
