class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int un = map.size();
        int[][] numsi = new int[un][2];
        
        int ni=0;
        for(int num : map.keySet()) {
            numsi[ni][0] = num;
            numsi[ni][1] = map.get(num);
            ni++;
        }

        Arrays.sort(numsi, (a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = numsi[un-k+i][0];
        }

        return res;
    }
}
