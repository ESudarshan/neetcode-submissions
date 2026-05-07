class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++) {
            int start = i;
            int end = i+k;
            int max = Integer.MIN_VALUE;
            for(int j=start; j<end; j++) {
                max = Math.max(max, nums[j]);
            } 
            ans[i] = max;
        }
        return ans;
        */
/*
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int n = nums.length;
        int[] ans = new int[n-k+1];

        int l = 0;
        for(int r=0; r<n; r++) {
             heap.offer(new int[] {nums[r], r});
             if(r-l+1 == k) {
                while(heap.peek()[1] < l) {
                    heap.poll();
                }
                ans[l] = heap.peek()[0];
                l++;
             }
        }
        return ans;
*/

        int n = nums.length;
        int[] ans = new int[n-k+1]; 

        Deque<Integer> dq = new LinkedList<>();
        int l=0;
        for(int r=0; r<n; r++) {
            while(!dq.isEmpty() && nums[r] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(r);

            if(dq.getFirst() < l) {
                dq.removeFirst();
            }

            if(r-l+1 == k) {
                ans[l] = nums[dq.getFirst()];
                l++;
            }
        }
        return ans;
    }
}
