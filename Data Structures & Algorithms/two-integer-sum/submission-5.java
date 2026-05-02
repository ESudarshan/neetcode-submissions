class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 
        // for(int i=0; i<nums.length; i++) {
        //     map.put(nums[i], i);
        // }
        for(int i=0; i<nums.length; i++) {
            Integer j = map.get(target-nums[i]);
            if(j != null && i!=j) {
                return new int[]{j, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
}
