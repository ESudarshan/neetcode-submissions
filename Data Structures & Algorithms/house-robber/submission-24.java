class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }

        int mintwo = nums[0];
        int minone = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++) {
            int temp = minone;
            minone = Math.max(minone, mintwo + nums[i]);
            mintwo = temp;
        }
        return minone;
    }
}
