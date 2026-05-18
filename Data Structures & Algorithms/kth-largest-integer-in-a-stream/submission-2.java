class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        int i=0;
        while(i < nums.length) {
            pq.offer(nums[i]);
            i++;
            if(pq.size() == (k+1)) {
                pq.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}
