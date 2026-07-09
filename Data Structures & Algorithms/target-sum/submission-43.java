class Solution {

    int[][] mem;

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
        mem = new int[n][sum*2+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        } 
        return subsetSum(nums, 0, n, t, sum);
    }

    public int subsetSum(int[] nums, int i, int n, int t, int offset) {
        if(i == n) {
            if(t == 0) {
                return 1;
            }
            return 0;
        }
        if(mem[i][t+offset] != -1) {
            return mem[i][t+offset];
        }
        return mem[i][t+offset] = subsetSum(nums, i+1, n, t-nums[i], offset) + subsetSum(nums, i+1, n, t, offset);
    }
}
