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

        int[] dp = new int[t+1];
        dp[0] = 1;

        for(int i=n-1; i>=0; i--) {
            for(int j=t; j>=0; j--) {
                if(nums[i] <= j) {
                    dp[j] = dp[j-nums[i]] + dp[j];
                }  
            }
        }
 
        return dp[t];
    }

}
