class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(nums);
         for(int i=0; i<n-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i+1;
            int r = n-1;
            int target = 0 - nums[i]; 
            while(l < r) {
                int sum = nums[l] + nums[r];
                if(sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                       r--;
                    }
                } else if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
         }
         return new ArrayList<>(ans);
    
    }
}
