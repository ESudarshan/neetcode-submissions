class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            for(int k=1; k<=nums[i]; k++) {
                if((i+k <= n-1) && dp[i+k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
