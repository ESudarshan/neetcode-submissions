class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) +1);
        }

        List<Integer>[] arr = new List[nums.length + 1];

        for(int i=0; i<nums.length+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int i=0;
        int j = nums.length; 
        while(i < k) {
            for(Integer a : arr[j]) {
                ans[i++] = a;
                if(i == k) {
                    break;
                }
            }
            j--;
        }
        return ans;
    }
}
