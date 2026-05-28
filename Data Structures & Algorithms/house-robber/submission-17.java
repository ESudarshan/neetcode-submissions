class Solution {

    int[] mem;

    public int rob(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        return rob(nums, 0, n);
    }

    public int rob(int[] nums, int i, int n) {
        if(i >= n) {
            return 0;
        }
        if(mem[i] == -1) {
            mem[i] = Math.max(rob(nums, i+1, n), nums[i] + rob(nums, i+2, n));
        }
        return mem[i];
    }
}
