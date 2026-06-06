class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n+1][n+1];

        for(int i=1; i<=n ; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for(int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        for(int mid=1; mid<=n; mid++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][mid] != Integer.MAX_VALUE && graph[mid][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][mid] + graph[mid][j]);
                    }
                }
            }
        }

        int maxTime = -1;
        for(int i=1; i<=n; i++) {
            maxTime = Math.max(maxTime, graph[k][i]);
        }

        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
