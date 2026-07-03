class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int next2 = 0;
        int next1 = cost[n-1];
        int dp;
        for(int i=n-2; i>=0; i--) {
            dp = cost[i] + Math.min(next1, next2);
            next2 = next1;
            next1 = dp;
        }
        return Math.min(next1, next2);
    }
    
}
