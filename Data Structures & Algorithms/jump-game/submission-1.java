class Solution {

    int[] mem;

    public boolean canJump(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        return canJump(nums, 0, n);
    }

    public boolean canJump(int[] nums, int i, int n) {
        if(i == n - 1) {
            return true;
        }

        if(mem[i] != -1) {
            return mem[i] == 1;
        }

        for(int k = 1; k <= nums[i] ; k++) {
            if(canJump(nums, i + k, n)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = 0;
        return false;
    }
}
