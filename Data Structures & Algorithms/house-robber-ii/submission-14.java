class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 1, n-1, n), rob(nums, 0, n-2, n));
    }

    public int rob(int[] nums, int start, int end, int size) {
        int n = end - start + 1;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[start];
        }
		int[] dp = new int[size+1];
		dp[end+1] = 0;
		dp[end] = nums[end];
		for(int i=end-1; i>=start; i--) {
			dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
		}
		return dp[start];
    }
}
