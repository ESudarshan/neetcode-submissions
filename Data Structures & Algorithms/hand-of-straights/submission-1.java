class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;

        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for(int i=0; i<n; i++) {
            if(!map.containsKey(hand[i])) {
               continue; 
            }
            for(int k=0; k<groupSize; k++) {
                int key = hand[i] + k; 
                if(!map.containsKey(key)) {
                    return false;
                }
                if(map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        return true;
    }
}
