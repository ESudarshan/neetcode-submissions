class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(map.keySet());

        while(!heap.isEmpty()) {
            int key = heap.peek();
            for(int k=key; k<key+groupSize; k++) {
                if(!map.containsKey(k)) {
                    return false;
                }
                if(map.get(k) == 1) {
                    if(k == heap.peek()) {
                        map.remove(k);
                        heap.poll();
                    } else {
                        return false;
                    }
                } else {
                    map.put(k, map.get(k) - 1);
                }
            }
        }

        return true;
    }
}
