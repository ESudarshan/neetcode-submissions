class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(Math.abs(target) > sum || (sum - target) % 2 != 0) {
            return 0;
        }

        int t = (sum - target) / 2;

        int[][] dp = new int[n+1][t+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<t+1; j++) {
                if(i == n) {
                    dp[i][j] = 0;
                    if(j == 0) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<=t; j++) {
                if(nums[i] <= j) {
                    dp[i][j] = dp[i+1][j-nums[i]] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }  
            }
        }
 
        return dp[0][t];
    }

}
