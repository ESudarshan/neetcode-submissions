class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] track = new double[target+1];
        for(int i=0; i<n; i++) {
            track[position[i]] = (double)(target-position[i])/speed[i];
        }

        double prevTime = 0.0;
        int fleets = 0;
        for(int i=target-1; i>=0; i--) {
            if(track[i] > 0.0) {
                if(track[i] > prevTime) {
                    prevTime = track[i];
                    fleets++;
                }
            }
        }
        return fleets;
    }
}
