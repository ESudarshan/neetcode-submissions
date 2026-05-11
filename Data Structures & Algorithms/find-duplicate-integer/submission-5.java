class Solution {
    public int findDuplicate(int[] nums) {
/*        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
*/ 
/*
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                return Math.abs(nums[i]);
            }
            nums[index] *= -1;
        }     
        return -1;
*/

        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;
        while(slow2 != slow) {
             slow = nums[slow];
             slow2 = nums[slow2];
        } 
        
        return slow2;
    }
}
