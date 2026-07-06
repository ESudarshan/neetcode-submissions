class Solution {

    int[][] mem;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2; 
        mem = new int[n][target+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return targetSum(nums, 0, n, target);
    }

    boolean targetSum(int[] nums, int i, int n, int target) {
        if(target == 0) {
            return true;
        }
        
        if(i == n) {
            return false;
        }
        
        if(mem[i][target] != -1) {
            return mem[i][target] == 0 ? false : true;
        }

        boolean res;
        if(nums[i] <= target) {
            res = targetSum(nums, i + 1, n, target - nums[i]) || targetSum(nums, i + 1, n, target);        
        } else {
            res = targetSum(nums, i + 1, n, target);
        } 
        
        mem[i][target] = (res == false) ? 0 : 1;
        
        return res;
    }
}
