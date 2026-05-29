class Solution {

    Map<Integer, Integer> mem;
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        mem = new HashMap<>();
        int res = change(coins, n, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int change(int[] coins, int n, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(mem.containsKey(amount)) {
            return mem.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for(int k=0; k<n; k++) {
            if(amount - coins[k] >= 0 ) {
                int resp = change(coins, n, amount - coins[k]);
                if(resp != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + resp);
                }
            }
        }
        mem.put(amount, res);
        return res;
    }
}
