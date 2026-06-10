class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        for(int i=0; i <n; i++) {
            int res = 0;
            for(int j=i+1; j<n; j++) {
                res = (j-i) * Math.min(heights[i], heights[j]);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
}
