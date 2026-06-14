class Solution {
    public int largestRectangleArea(int[] heights) {      
        int n= heights.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int min = heights[i];

            int l=i;
            for(l=i-1; l>=0; l--) {
                if(heights[l] < min) {
                    break;
                }
            }

            int r=i;
            for(r=i+1; r<n; r++) {
                if(heights[r] < min) {
                    break;
                }
            }

            ans = Math.max(ans, min * (r-l-1));
        }
        return ans;        
    }
}
