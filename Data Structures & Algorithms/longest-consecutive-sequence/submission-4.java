class Solution {
    public int longestConsecutive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums) {
        //     set.add(num);
        // }

        // for(int i=0; i<nums.length; i++) {
        //     if(5nums[i])
        // }

        if(nums.length == 0) {
            return 0;
        }
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
    }
}
