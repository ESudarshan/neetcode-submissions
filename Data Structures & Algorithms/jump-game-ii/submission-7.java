class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            int minJumps = n;
            for(int k=1; k<=nums[i] && (i+k)<n; k++) {
                minJumps = Math.min(minJumps, 1 + dp[i+k]);
            }
            dp[i] = minJumps;
        }
        return dp[0];
    }
}
