class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 0;
        int suffix = 0;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            prefix = prefix == 0 ? nums[i] : prefix * nums[i]; 
            suffix = suffix == 0 ? nums[n-1-i] : suffix * nums[n-1-i];
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
