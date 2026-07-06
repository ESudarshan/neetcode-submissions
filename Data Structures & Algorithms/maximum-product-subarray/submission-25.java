class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int currMaxProd = nums[0];
        int currMinProd = nums[0];
        
        for(int i=1; i<n; i++) {
            if(nums[i] < 0) {
                int temp = currMaxProd;
                currMaxProd = currMinProd;
                currMinProd = temp;    
            }
            currMaxProd = Math.max(currMaxProd * nums[i], nums[i]);
            currMinProd = Math.min(currMinProd * nums[i], nums[i]);
            res = Math.max(res, currMaxProd);
        }
        
        return res;
    }
}
