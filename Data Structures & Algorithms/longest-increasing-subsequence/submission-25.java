class Solution {

    int[][] mem;
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        mem = new int[n][n];
        for(int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return lis(nums, 0, -1, n);
    }

    public int lis(int[] nums, int i, int j, int n) {
        if(i == n) {
            return 0;
        }
        if(j != -1 && mem[i][j] != -1) {
            return mem[i][j];
        }
        int longest = 0;
        if(j == -1 || nums[j] < nums[i]) {
            longest = Math.max(longest, 1 + lis(nums, i + 1, i, n)); 
        }
        longest = Math.max(longest, lis(nums, i + 1, j, n));
        if(j != -1) {
            mem[i][j] = longest;
        }
        return longest;
    }

}
