class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int ans = 1;
        
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]-1)) {
                continue;
            } 
            int seq = 0;
            int num = nums[i];
            while(set.contains(num)) {
                num++;
                seq++;
            }
            ans = Math.max(ans, seq);
        }
        return ans;
    }
}
