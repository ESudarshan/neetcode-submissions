class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : hand) {
            if(!map.containsKey(num)) {
                continue;
            }
            int start = num;
            while(map.containsKey(start - 1)) {
                start --;
            }

            while(start <= num) {
                if(!map.containsKey(start)) {
                    start++;
                    continue;
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
            }
        }

        return true;
    }
}
