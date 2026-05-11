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

        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while(true) {
             slow = nums[slow];
             slow2 = nums[slow2];
            if(slow == slow2) {
                break;
            }
        } 
        
        return slow2;
    }
}
