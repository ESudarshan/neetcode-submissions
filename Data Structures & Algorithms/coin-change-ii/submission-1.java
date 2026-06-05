class Solution {

    Integer[][] mem;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        mem = new Integer[n][amount+1];
        return change(coins, 0, n, amount);
    }

    public int change(int[] coins, int i, int n, int amount) {
        if(i == n) {
            if(amount == 0) {
                return 1;
            }
            return 0;
        }
        if(amount < 0 ) {
            return 0;
        }
        if(mem[i][amount] == null) {
            mem[i][amount] = change(coins, i, n, amount-coins[i]) + change(coins, i+1, n, amount);
        }
        return mem[i][amount];
    }
}
