class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edgeTime = new HashMap<>();
        int e = times.length;
        for(int i=0; i<e; i++) {
            edgeTime.putIfAbsent(times[i][0], new ArrayList<int[]>());
            edgeTime.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);

        dfs(k, edgeTime, 0, time);
        System.out.println(Arrays.toString(time));
        int maxTime = -1;
        for(int i=1; i<=n; i++) {
            maxTime = Math.max(maxTime, time[i]); 
        }    
        
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    public void dfs(int i, Map<Integer, List<int[]>> edgeTime, int t, int[] time) {
        if(t >= time[i]) {
            return;
        }

        time[i] = t;

        if(!edgeTime.containsKey(i)) {
            return;
        }

        for(int[] et : edgeTime.get(i)) {
            dfs(et[0], edgeTime, time[i] + et[1], time);
        }
        
        return;
    }


}
