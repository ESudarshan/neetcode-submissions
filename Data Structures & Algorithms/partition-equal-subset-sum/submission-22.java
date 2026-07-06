class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2; 

        // DP Tab

        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0; i<=target; i++) {
            dp[n][i] = false;
        }
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=target; j++) {
                if(nums[i] <= j) {
                    dp[i][j] = dp[i+1][j - nums[i]] || dp[i+1][j];        
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][target];
    }

}
