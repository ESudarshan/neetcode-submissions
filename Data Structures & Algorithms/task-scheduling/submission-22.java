class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(char ch : map.keySet()) {
            maxHeap.offer(map.get(ch));
        }

        Queue<int[]> q = new LinkedList<>();
        int c = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            c++;
            
            if(!maxHeap.isEmpty()) {
                int f = maxHeap.poll();
                f--;
                if(f != 0) {
                    q.add(new int[] { c + n, f});
                }
            }

            if(!q.isEmpty() && q.peek()[0] == c) {
                int[] e = q.remove();
                maxHeap.offer(e[1]);
            }
        }

        return c;
    }
}
