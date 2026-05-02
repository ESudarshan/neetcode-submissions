class Solution {
    public int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));
        
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1; i<nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(ans));

        int suffixProduct = 1;
        for(int i=nums.length-1; i>=0; i--) {
            ans[i] = ans[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i]; 
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }
}  
