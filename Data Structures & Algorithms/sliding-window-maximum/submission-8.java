class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++) {
            int start = i;
            int end = i+k;
            int max = Integer.MIN_VALUE;
            for(int j=start; j<end; j++) {
                max = Math.max(max, nums[j]);
            } 
            ans[i] = max;
        }
        return ans;
    }
}
