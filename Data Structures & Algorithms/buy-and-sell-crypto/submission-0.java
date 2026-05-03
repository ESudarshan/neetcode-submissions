class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int current = prices[j] - prices[i];
                profit = Math.max(profit, current);
            }
        }
        return profit;
    }
}
