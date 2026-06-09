class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int zeros = 0;
        int zeroi = -1;
        int product = 1;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                zeroi = i;
                zeros++;
                if(zeros > 1) {
                    return res;
                }
            } else {
                product *= nums[i];
            }
        }

        if(zeros == 1) {
            res[zeroi] = product;
            return res;
        }

        for(int i=0; i<n; i++) {
            res[i] = product / nums[i];
        }

        return res;
    }
}  
