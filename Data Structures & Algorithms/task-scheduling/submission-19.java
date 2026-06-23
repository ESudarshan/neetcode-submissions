class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> fMap =new HashMap<>();
        for(char task : tasks) {
            fMap.put(task, fMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(char task : fMap.keySet()) {
            maxHeap.offer(fMap.get(task));
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int pt = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            pt++;
            if(!maxHeap.isEmpty()) {                
                int f = maxHeap.poll();
                f--; 
                if(f != 0) {
                    Pair pair = new Pair(f, pt + n);
                    q.add(pair);
                }
            }
            
            if(!q.isEmpty() && pt == q.element().getValue()) {
                Pair<Integer, Integer> pair = q.remove();
                maxHeap.offer(pair.getKey());
            }

        }

        return pt;
    }
}
