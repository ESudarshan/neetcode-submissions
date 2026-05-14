class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int i = 0;
        int j = 0;
        int k = 0;
        int mid = l / 2;
        int prevMedian = 0;
        int currMedian = 0;

        while(i < l1 && j < l2 && k <= mid) {
            prevMedian = currMedian;
            if(nums1[i] <= nums2[j]) {
                currMedian = nums1[i];
                i++;
                k++;
            } else {
                currMedian = nums2[j];
                j++;
                k++;  
            }
        }

        while(i < l1 && k != mid + 1) {
            prevMedian = currMedian;
            currMedian = nums1[i];
            i++;
            k++;
        }

        while(j < l2 && k != mid + 1) {
            prevMedian = currMedian;
            currMedian = nums2[j];
            j++;
            k++;
        }

        
        if(l % 2 == 1) {
            return currMedian;
        } 
        return (prevMedian + currMedian) / 2.0;
    }
}
