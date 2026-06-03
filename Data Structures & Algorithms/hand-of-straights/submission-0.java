class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;

        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        int groups = n / groupSize;
        int g = 0;
        while(g < groups) {
            int start = -1;
            for(Integer key : map.keySet()) {
                start = key;
                break;
            }
            for(int i=start; i<start+groupSize; i++) {
                if(!map.containsKey(i)) {
                    return false;
                }
                if(map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
            g++;
        }

        return true;
    }
}
