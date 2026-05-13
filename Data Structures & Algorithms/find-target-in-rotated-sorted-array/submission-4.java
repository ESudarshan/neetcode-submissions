class Solution {
    public int search(int[] nums, int target) {
/*
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
*/
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l < r) {
            int mid = l + ((r - l) / 2);
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int p = l;

        if(nums[p] <= target && target <= nums[n-1]) {
            l = p;
            r = n-1;
        } else {
            l = 0;
            r = p-1;
        }

        int res = binarySearch(nums, 0, p-1, target);
        if(res == -1) {
            res = binarySearch(nums, p, n-1, target);
        }
        return res;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
