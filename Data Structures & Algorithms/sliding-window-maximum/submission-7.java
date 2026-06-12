class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        for(int i=0; i<n; i++) {
            maxHeap.offer(i);
            if(i >= k-1) {
                while(maxHeap.peek() < i-k+1) {
                    maxHeap.poll();
                }
                res[i-k+1] = nums[maxHeap.peek()];
            }
        }
        return res;
    }
}
