class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return sum(nums, 0, n, target);    
    }

    public int sum(int[] nums, int i, int n, int target) {
        if(i == n) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }

        return sum(nums, i+1, n, target + nums[i]) + sum(nums, i+1, n, target - nums[i]);
    }

}
