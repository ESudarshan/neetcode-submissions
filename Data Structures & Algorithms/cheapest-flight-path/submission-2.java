class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i=0; i<n; i++) {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;

        for(int i=1; i<=k+1; i++) {
            int[] tPrices = Arrays.copyOf(prices, n);
            for(int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if(prices[s] != Integer.MAX_VALUE && (prices[s] + p) < tPrices[d]) {
                    tPrices[d] = prices[s] + p;
                }
            }
            prices = tPrices;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst]; 
    }
}
