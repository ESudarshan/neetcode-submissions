class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
		int next2 = 0;
		int next1 = nums[n-1];
		int dp = 0;
		for(int i=n-2; i>=0; i--) {
			dp = Math.max(next1, nums[i] + next2);
			next2 = next1;
			next1 = dp;
		}
		return dp;
    }
}
