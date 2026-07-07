class Solution {

    int[][] mem;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        mem = new int[n+1][n];
        for(int i=0; i<=n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return lis(nums, -1, 0, n);
    }

    public int lis(int[] nums, int prev, int i, int n) {
        if(i == n) {
            return 0;
        }

        if(mem[prev+1][i] != -1) {
            return mem[prev+1][i];
        }

        if(prev == -1 || nums[prev]<nums[i]) {
            return mem[prev+1][i] = Math.max(1 + lis(nums, i, i+1, n), lis(nums, prev, i+1, n));
        } else {
            return mem[prev+1][i] = lis(nums, prev, i+1, n);
        }
    }

}
