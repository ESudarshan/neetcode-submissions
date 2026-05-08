class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
/*        
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int d=0;
            for(int j=i+1; j<n; j++) {
                if(temperatures[j] > temperatures[i]) {
                    d = j-i;
                    break;
                }
            }
            ans[i] = d;
        }
        return ans;
    */        

        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ) {
                int res = i-stack.peek();
                ans[stack.peek()] = res;
                stack.pop();
            }
            stack.push(i);
        }
        return ans; 
    }

}
