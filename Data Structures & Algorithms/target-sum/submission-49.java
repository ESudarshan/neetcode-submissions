class Solution {

    int mem[][];
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        mem = new int[n][sum*2+1];
        return sum(nums, 0, n, target, sum);
    }

    public int sum(int[] nums, int i, int n, int target, int offset) {
        if(i == n) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }

        return sum(nums, i+1, n, target + nums[i], offset) + sum(nums, i+1, n, target - nums[i], offset);
    }

}
