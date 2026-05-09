class Solution {
    public int search(int[] nums, int target) {
        /*
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l <= r) {
            int mid = l+((r-l)/2);
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
        */
        
        return search(nums, target, 0, nums.length-1);
    }

    public int search(int[] nums, int target, int l, int r) {
        if(l > r) {
            return -1;
        }
        int mid = l+((r-l)/2);
        if(nums[mid] == target) {
            return mid;
        }

        if(target < nums[mid]) {
            return search(nums, target, l, mid-1);
        }
        return search(nums, target, mid+1, r);
    }
}
