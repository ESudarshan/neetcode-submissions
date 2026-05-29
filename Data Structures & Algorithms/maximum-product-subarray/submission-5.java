class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        return maxP(nums, 0, n);
    }

    public int maxP(int[] nums, int i, int n) {
        if(i == n) {
            return Integer.MIN_VALUE;
        }
        int res = nums[i];
        int prod = nums[i];
        for(int k=i+1; k<n; k++) {
            prod *= nums[k];
            res = Math.max(res, prod);
        }
        return Math.max(res, maxP(nums, i+1, n));
    }
}
