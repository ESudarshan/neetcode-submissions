class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> fMap =new HashMap<>();
        for(char task : tasks) {
            fMap.put(task, fMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(char task : fMap.keySet()) {
            maxHeap.offer(new Pair(task, fMap.get(task)));
        }

        Deque<Pair<Character, Integer>> dq = new LinkedList<>();
        int pt = 0;
        while(!maxHeap.isEmpty() || !dq.isEmpty()) {
        // while(!fMap.isEmpty()) {
            pt++;
            if(!maxHeap.isEmpty()) {
                Pair<Character, Integer> pair = maxHeap.poll();
                char t = pair.getKey();
                int f = pair.getValue();
                // System.out.print("-["+ pt + "|" + t + "|" + f +"]-");
                f--; 
                if(f != 0) {
                    fMap.put(t, f);
                    pair = new Pair(t, pt);
                    dq.add(pair);
                } else {
                    fMap.remove(t);
                }
            }
            
            if(!dq.isEmpty()) {
                if(pt == (dq.peekFirst().getValue() + n)) {
                    Pair<Character, Integer> pair = dq.removeFirst();
                    char t = pair.getKey();
                    int f = fMap.get(t);
                    pair = new Pair(t, f);
                    maxHeap.offer(pair);
                }
            }
        }

        return pt;
    }
}
