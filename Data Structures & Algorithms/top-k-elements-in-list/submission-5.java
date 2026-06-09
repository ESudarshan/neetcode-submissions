class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) +1);
        }

        List<Integer>[] arr = new List[nums.length + 1];

        for(int i=0; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int ki=0;
        for(int i=n; i>=1; i--) {
            for(int num : arr[i]) {
                ans[ki] = num;
                ki++;
                if(ki == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
