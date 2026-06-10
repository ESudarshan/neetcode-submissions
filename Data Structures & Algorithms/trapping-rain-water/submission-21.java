class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        int[] lMax = new int[n];
        lMax[0] = -1;
        for(int i=1; i<n; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i-1]);
        }

        int[] rMax = new int[n];
        rMax[n-1] = -1;
        for(int i=n-2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i+1]);
        }

        for(int i=0; i<n; i++) {            
            if(Math.min(lMax[i], rMax[i]) > height[i]) {
                res += Math.min(lMax[i], rMax[i]) - height[i];
            }
        }

        return res;
    }
}
