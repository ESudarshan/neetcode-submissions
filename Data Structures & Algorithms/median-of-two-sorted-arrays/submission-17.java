class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int half = (len + 1) / 2;

        int l = 0;
        int r = len1;
        while(l <= r) {
            int mid1 = l + ((r - l) / 2);
            int mid2 = half - mid1; 

            int left1 = (mid1-1) >= 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int right1 = (mid1) < len1 ? nums1[mid1] : Integer.MAX_VALUE;
            int left2 = (mid2-1) >= 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int right2 = (mid2) < len2 ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1) {
                if(len % 2 == 1) {
                    return Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            } else if(left1 > right2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }

        }
        return -1;
    }
}
