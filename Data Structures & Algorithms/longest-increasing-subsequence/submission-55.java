class Solution {

    int[][] mem;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        mem = new int[n+1][n];
        for(int i=0; i<=n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return lis(nums, 0, -1, n);
    }

    public int lis(int[] nums, int i, int j, int n) {
        if(i == n) {
            return 0;
        }

        if(mem[j+1][i] != -1) {
            return mem[j+1][i];
        }

        if(j == -1 || nums[j]<nums[i]) {
            return mem[i][j+1] = Math.max(1 + lis(nums, i+1, i, n), lis(nums, i+1, j, n));
        } else {
            return mem[i][j+1] = lis(nums, i+1, j, n);
        }
    }

}