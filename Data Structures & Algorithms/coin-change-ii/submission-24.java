class Solution {

    int[][] mem;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        mem = new int[n][amount+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return change(coins, 0, n, amount, mem);
    }

    public int change(int[] coins, int i, int n, int amount, int[][] mem) {
        if(amount == 0) {
            return 1;
        }

        if(i == n) {
            return 0;
        }

        if(mem[i][amount] != -1) {
            return mem[i][amount];
        }

        int res;
        if(coins[i] <= amount) {
            res = change(coins, i, n, amount - coins[i], mem) + change(coins, i+1, n, amount, mem);
        } else {
            res = change(coins, i+1, n, amount, mem);
        }

        mem[i][amount] = res;
        return res;
    }
}
