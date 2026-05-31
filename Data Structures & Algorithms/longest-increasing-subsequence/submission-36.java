class Solution {

    int[] mem;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        
        int res = 0;
        for(int i=0; i<n; i++) {
            Arrays.fill(mem, -1);
            res = Math.max(res, lis(nums, i, n));
        }
        return res;
    }

    public int lis(int[] nums, int i, int n) {
        if(i == n) {
            return 0;
        }
        if(mem[i] != -1) {
            return mem[i];
        }
        int lis = 1;
        for(int j=i+1; j<n; j++) {
            if(nums[i] < nums[j]) {
                lis = Math.max(lis, 1 + lis(nums, j, n));
            }
        }
        mem[i] = lis;
        return lis;
    }
}
