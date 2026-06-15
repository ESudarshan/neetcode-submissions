class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;
        int ans = max;
        while(l <= r) {
            int mid = l + ((r - l) / 2);
            int hours = hours(piles, mid);
            System.out.println("mid="+mid+" hours="+ hours);
            if(hours <= h) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    int hours(int[] piles, int k) {
        int hours = 0;
        for(int j=0; j<piles.length; j++) {
            hours += (piles[j] % k == 0 ? piles[j] / k : (piles[j] / k) + 1);
        }
        return hours;
    }

}
