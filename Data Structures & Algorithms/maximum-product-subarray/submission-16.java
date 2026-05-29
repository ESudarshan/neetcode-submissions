class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            prefix[i] = i-1 < 0 ? nums[0] : (prefix[i-1] == 0 ? nums[i] : prefix[i-1] * nums[i]); 
            suffix[n-1-i] = n-i >= n ? nums[n-1] : (suffix[n-i] == 0 ? nums[n-1-i] : suffix[n-i] * nums[n-1-i]); 
            res = Math.max(res, Math.max(prefix[i], suffix[n-1-i]));
        }
        return res;
    }
}
