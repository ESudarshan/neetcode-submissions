class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pop = stack.pop();
                int h = pop[1];
                int w = i-pop[0];
                ans = Math.max(ans, h * w);
                start = pop[0];
            }
            stack.push(new int[] {start, heights[i]});    
        }

        while(!stack.isEmpty()) {
                int[] pop = stack.pop();
                int h = pop[1];
                int w = n-pop[0];
                ans = Math.max(ans, h * w);
        }
        
        return ans;
    }
}
