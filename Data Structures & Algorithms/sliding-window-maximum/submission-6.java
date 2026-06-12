class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
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
