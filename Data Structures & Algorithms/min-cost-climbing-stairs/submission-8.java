class Solution {

    int[] mem;
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        mem = new int[n+1];
        Arrays.fill(mem, -1);
        int minCostAt0 = minCost(cost, 0, n);
        // Arrays.fill(mem, -1);
        int minCostAt1 = minCost(cost, 1, n);
        return Math.min(minCostAt0, minCostAt1);
    }

    public int minCost(int[] cost, int floor, int n) {
        if(floor > n) {
            return Integer.MAX_VALUE;
        }
        if(floor == n) {
            return 0;
        }
        if(mem[floor] != -1) {
            return mem[floor];
        }
        mem[floor] = cost[floor] + Math.min(minCost(cost, floor + 1, n), minCost(cost, floor + 2, n));
        return mem[floor];    
    }
}
