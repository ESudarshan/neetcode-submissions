class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int fb = flowerbed.length;
        for(int i=0; i<fb; i++) {
            if(isValid(flowerbed, i, fb)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return n <= count;
    }

    public boolean isValid(int[] fb, int i, int n) {
        if(fb[i] == 1 
            || (i > 0 && fb[i-1] == 1)
            || (i < (n-1) && fb[i+1] == 1)) {
            return false;
        }
        return true;
    }
}