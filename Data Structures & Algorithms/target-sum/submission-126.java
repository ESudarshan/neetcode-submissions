class Solution {
    
    int[][] mem;
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        mem = new int[n][(sum*2)+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return sum(nums, 0, 0, target, sum);    
    }

    public int sum(int[] nums, int i, int currSum, int target, int offset) {
        if(i == nums.length) {
            if(currSum == target) {
                return 1;
            }
            return 0;
        }

        if(mem[i][currSum+offset] != -1) {
            return mem[i][currSum+offset];
        }

        return mem[i][currSum+offset] = sum(nums, i+1, currSum + nums[i], target, offset) + sum(nums, i+1, currSum - nums[i], target, offset);
    }

}
