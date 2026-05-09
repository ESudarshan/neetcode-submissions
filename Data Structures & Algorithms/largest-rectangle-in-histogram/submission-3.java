class Solution {
    public int largestRectangleArea(int[] heights) {
/*        
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
*/

/*
        int n = heights.length;
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] right = new int[n];
        stack.clear();
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, heights[i] * (right[i]-left[i]-1));
        }
        return ans;
*/

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
