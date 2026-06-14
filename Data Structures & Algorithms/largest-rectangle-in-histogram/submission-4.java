class Solution {
    public int largestRectangleArea(int[] heights) {     
        int n= heights.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int min = heights[i];
            for(int j=i; j<n; j++) {
                min = Math.min(min, heights[j]);
                ans = Math.max(ans, min * (j-i+1));
            }
        }
        return ans;
    }
}
