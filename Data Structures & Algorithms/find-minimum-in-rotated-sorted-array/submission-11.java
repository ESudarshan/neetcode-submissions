class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        while(l <= r) {
            if(nums[l] <= nums[r]) {
                return Math.min(min, nums[l]);
            }
            int mid = l + ((r - l) / 2);
            if(nums[l] <= nums[mid]) {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                r =  mid - 1;
            }
        }
        return -1;

    }
}
