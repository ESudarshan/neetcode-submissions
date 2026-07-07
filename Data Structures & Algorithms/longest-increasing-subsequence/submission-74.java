class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=-1; j--) {
                if(j == -1 || nums[j]<nums[i]) {
                    curr[j+1] = Math.max(1 + next[i+1], next[j+1]);
                } else {
                    curr[j+1] = next[j+1];
                }
            }
            next = curr;
        }

        return curr[0];
    }

}