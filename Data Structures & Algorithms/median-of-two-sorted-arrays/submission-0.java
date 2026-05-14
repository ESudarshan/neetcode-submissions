class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int[] sorted = new int[l];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l1 && j < l2) {
            if(nums1[i] <= nums2[j]) {
                sorted[k] = nums1[i];
                i++;
                k++;
            } else {
                sorted[k] = nums2[j];
                j++;
                k++;  
            }
        }

        while(i < l1) {
            sorted[k] = nums1[i];
            i++;
            k++;
        }

        while(j < l2) {
            sorted[k] = nums2[j];
            j++;
            k++;
        }

        int mid = l / 2;
        if(l % 2 == 1) {
            return sorted[mid];
        } 
        return (double)(sorted[mid] + sorted[mid - 1]) / 2;

    }
}
