class Solution {
    public int trap(int[] height) {
/*
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
 */

 /*
        int n=height.length;

        int[] lMax = new int[n];
        lMax[0] = -1;
        for(int i=1; i<n; i++) {
            lMax[i] = Math.max(height[i-1], lMax[i-1]);
        }
        
        int[] rMax = new int[n];
        rMax[n-1] = -1;
        for(int i=n-2; i>=0; i--) {
            rMax[i] = Math.max(height[i+1], rMax[i+1]);
        }

        int ans=0;
        for(int i=0; i<n; i++) {
            if(Math.min(lMax[i], rMax[i]) > height[i]) {
                ans += Math.min(lMax[i], rMax[i]) - height[i];
            }
        }

        return ans;
*/

        int n = height.length;
        int l = 0;
        int r = n-1;
        int lMax = -1;
        int rMax = -1;
        int ans  = 0;
        List<Integer> list = new ArrayList<>();
        while(l <= r) {
            if(lMax <= rMax) {
                System.out.println("l-"+l+";lMax-"+lMax+";res-"+Math.max(0, lMax - height[l]));
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                System.out.println("r-"+r+";rMax-"+rMax+";res-"+Math.max(0, rMax - height[r]));
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return ans;

    }
}
