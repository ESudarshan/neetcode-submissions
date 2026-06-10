class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i=0; i<n; i++) {
            int lMax = -1;
            for(int l=0; l<i; l++) {
                lMax = Math.max(lMax, height[l]);
            }

            int rMax = -1;
            for(int r=i+1; r<n; r++) {
                rMax = Math.max(rMax, height[r]);
            }
            
            if(Math.min(lMax, rMax) > height[i]) {
                res += Math.min(lMax, rMax) - height[i];
            }
        }

        return res;
    }
}
