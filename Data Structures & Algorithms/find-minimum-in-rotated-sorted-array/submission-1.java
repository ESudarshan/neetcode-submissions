class Solution {
    public int findMin(int[] nums) {
/*
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
*/
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        while(l <= r) {
            if(nums[l] <= nums[r]) {
                return Math.min(min, nums[l]);
            }
            int mid = l + ((r - l) / 2);
            min = Math.min(min, nums[mid]);
            if(nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r =  mid - 1;
            }
        }
        return -1;

    }
}
