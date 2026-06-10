class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lMax = -1;
        int ans = 0;
        for(int i=0; i<n; i++) {
            int rMax = -1;
            for(int j = i+1; j<n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            int add = Math.min(lMax, rMax) - height[i];
            if(add > 0 ) {
                ans += add;
            }
            lMax = Math.max(lMax, height[i]); 
        }
        return ans;
    }
}
