class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        for(int i=n-1; i>=0; i--) {
            int longest = 1;
            for(int j=i+1; j<n; j++) {
                if(nums[i] < nums[j]) {
                    longest = Math.max(longest, 1 + dp[j]); 
                }
            }
            dp[i] = longest;
            res = Math.max(res, longest);
        }
        return res; 
    }
}
