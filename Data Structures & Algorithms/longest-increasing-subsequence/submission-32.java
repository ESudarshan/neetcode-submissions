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
        for(int k=i; k<n; k++) {
            if(j == -1 || nums[j] < nums[k]) {
                longest = Math.max(longest, 1 + lis(nums, k + 1, k, n)); 
            }
        }

        if(j != -1) {
            mem[i][j] = longest;
        }
        return longest;
    }

}
