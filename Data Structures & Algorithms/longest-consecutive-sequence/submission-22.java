class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        /*
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int ans = 1;
        int len = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            } 
            
            if(nums[i] == nums[i-1] + 1) {
                len++;
                ans = Math.max(ans, len);
            } else {
                len = 1;
            }
        }
        return ans;
        */

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int ans = 1;
        
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]-1)) {
                continue;
            } 
            int seq = 1;
            int num = nums[i];
            while(set.contains(num + 1)) {
                num = num + 1;
                seq++;
            }
            ans = Math.max(ans, seq);
        }
        return ans;
    }
}
