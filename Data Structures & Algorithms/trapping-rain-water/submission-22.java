class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int lMax = -1;
        int rMax = -1;
        int ans  = 0;
        while(l <= r) {
            if(lMax <= rMax) {
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return ans;

    }
}
