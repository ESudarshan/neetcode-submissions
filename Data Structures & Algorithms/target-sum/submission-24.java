class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if((sum - target) % 2 != 0) {
            return 0;
        }
        int t = (sum - target) / 2;
        return subsetSum(nums, 0, n, t);
    }

    public int subsetSum(int[] nums, int i, int n, int t) {
        if(i == n) {
                    if(t == 0) {
            return 1;
        }
            return 0;
        }

        return subsetSum(nums, i+1, n, t-nums[i]) + subsetSum(nums, i+1, n, t);
    }
}
