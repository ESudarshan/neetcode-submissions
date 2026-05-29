class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i=0; i<n; i++) {
            prefix[i] = i-1 < 0 ? nums[0] : (prefix[i-1] == 0 ? nums[i] : prefix[i-1] * nums[i]); 
        }
        for(int i=n-1; i>=0; i--) {
            suffix[i] = i+1 >= n ? nums[n-1] : (suffix[i+1] == 0 ? nums[i] : suffix[i+1] * nums[i]); 
        }
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            res = Math.max(res, Math.max(prefix[i], suffix[i]));
        }
        return res;
    }
}
