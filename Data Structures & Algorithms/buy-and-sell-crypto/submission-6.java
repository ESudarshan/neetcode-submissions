class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // if()
        int profit = 0;
        int buy = prices[0];
        for(int i=1; i<n; i++) {
            int sell = prices[i];
            profit = Math.max(profit, sell - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}
