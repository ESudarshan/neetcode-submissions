class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return sum(nums, 0, 0, target);    
    }

    public int sum(int[] nums, int i, int currSum, int target) {
        if(i == nums.length) {
            if(currSum == target) {
                return 1;
            }
            return 0;
        }

        return sum(nums, i+1, currSum + nums[i], target) + sum(nums, i+1, currSum - nums[i], target);
    }

}
