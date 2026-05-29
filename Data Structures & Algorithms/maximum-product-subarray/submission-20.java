class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++) {
            if(nums[i] < 0) {
                int temp = currMin;
                currMin = currMax;
                currMax = temp;
            }
            currMax = Math.max(currMax * nums[i], nums[i]);
            currMin = Math.min(currMin * nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
