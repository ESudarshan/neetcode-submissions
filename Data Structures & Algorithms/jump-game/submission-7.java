class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return canJump(nums, 0, n);
    }

    public boolean canJump(int[] nums, int i, int n) {
        if(i == n - 1) {
            return true;
        }
        

        for(int k = 1; k <= nums[i] ; k++) {
            if((i + k) <= n-1 && canJump(nums, i + k, n)) {
                return true;
            }
        }

        return false;
    }
}
