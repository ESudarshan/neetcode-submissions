class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for(int num : map.keySet()) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
