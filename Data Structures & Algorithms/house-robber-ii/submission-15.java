class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 1, n-1), rob(nums, 0, n-2));
    }

    public int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[start];
        }
		int next2 = 0;
		int next1 = nums[end];
		int dp = 0;
		for(int i=end-1; i>=start; i--) {
			dp = Math.max(next1, nums[i] + next2);
			next2 = next1;
			next1 = dp;
		}
		return dp;
    }
}
