class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        for(int i=1; i<=n-1; i++) {
            for(int[] edge : times) {
                if(time[edge[0]] != Integer.MAX_VALUE) {
                    time[edge[1]] = Math.min(time[edge[1]], time[edge[0]] + edge[2]);
                }
            }
        }

        int maxTime = -1;
        for(int i=1; i<=n; i++) {
            maxTime = Math.max(maxTime, time[i]);
        }

        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
