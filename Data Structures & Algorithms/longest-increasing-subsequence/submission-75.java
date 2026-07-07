class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=-1; j--) {
                if(j == -1 || nums[j]<nums[i]) {
                    dp[j+1] = Math.max(1 + dp[i+1], dp[j+1]);
                } else {
                    dp[j+1] = dp[j+1];
                }
            }
        }

        return dp[0];
    }

}