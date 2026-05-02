class Solution {
    public int[] productExceptSelf(int[] nums) {
        System.out.println(Arrays.toString(nums));
        
        int[] left = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i == 0) {
                left[i] =  1;
            } else {
                left[i] = left[i-1] * nums[i-1];
            }
        }
        System.out.println(Arrays.toString(left));

        int[] right = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            if(i == nums.length-1) {
                right[i] =  1;
            } else {
                right[i] = right[i+1] * nums[i+1];
            }
        }
        System.out.println(Arrays.toString(right));

        int[] ans = new int[nums.length];
        for(int i=0; i<ans.length; i++) {
            ans[i] = left[i] * right[i];
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }
}  
