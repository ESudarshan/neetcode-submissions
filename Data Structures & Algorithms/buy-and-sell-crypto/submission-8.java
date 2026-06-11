class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0;
        int r = 1;
        int res = 0;
        while(r < n) {
            if(prices[r] > prices[l]) {
                res = Math.max(res, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return res;
    }
}
