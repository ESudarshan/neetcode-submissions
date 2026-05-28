class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }

        int robMinusTwo = nums[0];
        int robMinusOne = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++) {
            int temp = robMinusOne;
            robMinusOne = Math.max(robMinusOne, robMinusTwo + nums[i]);
            robMinusTwo = temp;
        }
        return robMinusOne;
    }
}
