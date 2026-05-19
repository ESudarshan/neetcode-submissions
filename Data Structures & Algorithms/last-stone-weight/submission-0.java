class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) ->  b - a);
        for(int stone : stones) {
            heap.offer(stone);
        }

        while(heap.size() > 1) {
            int w1 = heap.poll();
            int w2 = heap.poll();
            int w = w1 - w2; 
            if(w != 0) {
                heap.offer(w);
            }
        }

        if(heap.size() == 1) {
            return heap.peek();
        }

        return 0;
    }
}
