class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        int dp = 0;
        int p2 = 1;
        int p1 = 1;

        for(int i=n-2; i>=0; i--) {
            dp = p1 + p2;
            p2 = p1;
            p1 = dp;
        }

        return dp;
    }
}
