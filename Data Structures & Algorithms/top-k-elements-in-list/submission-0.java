class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int f= freq.getOrDefault(nums[i], 0);
            f++;
            freq.put(nums[i], f);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList(freq.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue().compareTo(a.getValue()));

        int[] ans = new int[k];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : entryList) {
                ans[i] = entry.getKey();
                i++;
                if(i == k) {
                    break;
                }
        }

        return ans;
    }
}
