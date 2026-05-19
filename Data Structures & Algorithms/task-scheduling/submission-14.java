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

        Queue<Pair<Character, Integer>> q = new LinkedList<>();
        int pt = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            if(maxHeap.isEmpty()) {
                pt = q.element().getValue();
            } else if(!maxHeap.isEmpty()) {
                pt++;
                Pair<Character, Integer> pair = maxHeap.poll();
                char t = pair.getKey();
                int f = pair.getValue();
                // System.out.print("-["+ pt + "|" + t + "|" + f +"]-");
                f--; 
                if(f != 0) {
                    fMap.put(t, f);
                    pair = new Pair(t, pt + n);
                    q.add(pair);
                } else {
                    fMap.remove(t);
                }
            }
            
            if(!q.isEmpty() && pt == q.element().getValue()) {
                Pair<Character, Integer> pair = q.remove();
                pair = new Pair(pair.getKey(), fMap.get(pair.getKey()));
                maxHeap.offer(pair);
            }

        }

        return pt;
    }
}
