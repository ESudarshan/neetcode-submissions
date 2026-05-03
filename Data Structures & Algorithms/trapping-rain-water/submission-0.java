class Solution {
    public int trap(int[] height) {
        int n=height.length;
        
        int[] lMax = new int[n];
        lMax[0] = -1;
        int max = -1;
        for(int i=1; i<n; i++) {
            lMax[i] = Math.max(height[i-1], max);
            max = lMax[i];
        }
        System.out.println(Arrays.toString(lMax));
        
        int[] rMax = new int[n];
        rMax[n-1] = -1;
        max = -1;
        for(int i=n-2; i>=0; i--) {
            rMax[i] = Math.max(height[i+1], max);
            max = rMax[i];
        }
        System.out.println(Arrays.toString(rMax));

        int ans=0;
        for(int i=0; i<n; i++) {
            if(Math.min(lMax[i], rMax[i]) > height[i]) {
                ans += Math.min(lMax[i], rMax[i]) - height[i];
            }
        }
        
        return ans;
    }
}
