class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++) {
            int prevCurrMax = currMax;
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(currMin * nums[i], prevCurrMax * nums[i]), nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
