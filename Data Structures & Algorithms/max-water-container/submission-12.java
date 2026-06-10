class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length -1;
        int ans = 0;
        while(i<j) {
            int res = (j-i) * Math.min(heights[i], heights[j]);
            ans = Math.max(ans, res);
            if(heights[i] <= heights[j]) {
                i++;
            } else if(heights[i] > heights[j]){
                j--;
            } 
        }
        return ans;
    }
}
