class Solution {

    int[] mem; 

    public int rob(int[] nums) {
        int n = nums.length;
        mem = new int[n+1];
        Arrays.fill(mem, -1);
        return Math.max(rob(nums, 0, n), rob(nums, 1, n));
    }

    int rob(int[] nums, int i, int n) {
        if(i >= n) {
            return 0;
        }
        int money = 0;
        if(mem[i] != -1) {
            return mem[i];
        }
        for(int j=i+2; j<n; j++) {
            money = Math.max(money, rob(nums, j, n));
            // mem[j] != -1 ? mem[j] : 
        }
        mem[i] = nums[i] + money;
        return mem[i];
    }

}
