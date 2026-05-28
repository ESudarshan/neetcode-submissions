class Solution {

    int[] mem;

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        mem = new int[n];
        Arrays.fill(mem, -1);
        int firstExcluded = rob(nums, 1, n);
        Arrays.fill(mem, -1);
        int lastExcluded = rob(nums, 0, n-1);
        return Math.max(firstExcluded, lastExcluded);
    }

    public int rob(int[] nums, int i, int n) {
        if(i >= n) {
            return 0;
        }
        if(mem[i] == -1) {
            mem[i] = Math.max(rob(nums, i + 1, n), nums[i] + rob(nums, i + 2, n));
        }
        return mem[i];
    }
}
