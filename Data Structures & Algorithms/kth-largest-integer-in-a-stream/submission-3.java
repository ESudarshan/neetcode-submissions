class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        int i=0;
        while(i < nums.length) {
            pq.offer(nums[i]);
            i++;
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }
}
