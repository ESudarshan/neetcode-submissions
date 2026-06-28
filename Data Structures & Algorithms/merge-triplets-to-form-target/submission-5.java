class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] tar = new int[3];
        
        for(int[] t : triplets) {
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                for(int i=0; i<3; i++) {
                    tar[i] = Math.max(tar[i], t[i]);
                }
            }
        }

        for(int i=0; i<3; i++) {
            if(tar[i] != target[i]) {
                return false;
            }
        }

        return true;
    }
}
