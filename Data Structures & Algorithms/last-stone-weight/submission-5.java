class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        int first = Integer.MIN_VALUE;
        for(int stone : stones) {
            first = Math.max(first, stone);
        }

        int[] buckets = new int[first + 1];
        for(int stone : stones) {
            buckets[stone]++;
        }

        int second = first;

        while(first > 0) {
            if(buckets[first] % 2 == 0) {
                first--;
                continue;
            }

            second = first - 1;
            while(second > 0 && buckets[second] == 0) {
                second--;
            }

            if(second == 0) {
                return first;
            }

            buckets[first]--;
            buckets[second]--;
            buckets[first - second]++;

            first = Math.max(second, first - second);
        }

        return 0;
    }
}
