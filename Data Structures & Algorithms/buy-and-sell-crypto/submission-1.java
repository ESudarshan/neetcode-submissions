class Solution {
    public int maxProfit(int[] prices) {
        /*
        int n = prices.length;
        int profit = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int current = prices[j] - prices[i];
                profit = Math.max(profit, current);
            }
        }
        return profit;
        */

        int n = prices.length;
        int[] rMax = new int[n];
        rMax[n-1] = -1; 
        for(int i=n-2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1], prices[i+1]);
        }

        int ans = 0;
        for(int i=0; i<n-1; i++) {
            ans = Math.max(ans, rMax[i] - prices[i]);
        }
        return ans;

    }
}
