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
        
        if(i == n || target < 0) {
            return false;
        }

        if(mem[i][target] != -1) {
            return mem[i][target] == 0 ? false : true;
        }

        for(int k=i; k<n; k++) {
            if(targetSum(nums, k + 1, n, target - nums[k])) {
                mem[i][target] = 1;
                return true;
            }
        }
        mem[i][target] = 0;
        return false;
    }
}
