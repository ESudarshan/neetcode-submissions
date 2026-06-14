class Solution {
    public int largestRectangleArea(int[] heights) {      
        int n= heights.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int min = heights[i];

            int l;
            for(l=i; l>=0; l--) {
                if(heights[l] < min) {
                    break;
                }
            }

            int r;
            for(r=i; r<n; r++) {
                if(heights[r] < min) {
                    break;
                }
            }

            ans = Math.max(ans, min * (r-l-1));
        }
        return ans;        
    }
}
